-- Name : Jack Durrant

-- NOTES

SELECT * FROM Performance;
SELECT * FROM Performer;
SELECT * FROM PerformerSkill;
SELECT * FROM Region;
SELECT * FROM Skill;
SELECT * FROM TheatreGroup;

-- QUESTION 1 

SELECT
	GroupName,
	AnnualRevenue
FROM TheatreGroup
WHERE AnnualRevenue < 15000
ORDER BY AnnualRevenue DESC;

-- QUESTION 2

SELECT
	ROUND(
		SUM(AnnualRevenue) / 12,
		2
	)
	AS TotalMonthlyRevenue
FROM TheatreGroup;

-- QUESTION 3

SELECT
	GroupID,
	GroupName
FROM TheatreGroup
WHERE DateStarted >= '2009-07-24'
ORDER BY GroupName ASC;

-- QUESTION 4

INSERT INTO Skill (
	SkillID,
	SkillName
) VALUES (
	(SELECT COUNT(*) FROM Skill) + 1,
	'Ballet'
);

-- QUESTION 5

SELECT
	ROUND(
		(SUM(
			AnnualRevenue
		) / (
			SELECT COUNT(*) FROM TheatreGroup
		)), 2
	) AS AverageMonthlyRevenue
FROM TheatreGroup;

-- QUESTION 6

SELECT
	ROUND(
		SUM(
			AnnualRevenue
		), 2
	) AS AverageAnnualRevenue
FROM TheatreGroup;

-- QUESTION 7

SELECT
	GroupName,
	TheatreName
FROM TheatreGroup
WHERE TheatreName <> '';

-- QUESTION 8

SELECT GroupName
FROM TheatreGroup;

-- QUESTION 9

SELECT
	DISTINCT GroupName -- ,
--	ShowName
FROM TheatreGroup
JOIN Performance ON TheatreGroup.GroupID = Performance.GroupID
WHERE ShowName IN (
	'Chicago',
	'Wicked'
);

-- QUESTION 10

GO;

CREATE VIEW AnnualRevenueIncreasePercentage AS
	SELECT
		GroupID,
		CASE
			WHEN GroupID IN (300, 500)
				THEN 5
			WHEN GroupID IN (700)
				THEN 10
			ELSE 0
		END
		AS AnnualRevenueIncreasePercentage
	FROM TheatreGroup;
GO;

SELECT
	GroupName,
	(SELECT * FROM AnnualRevenueIncreasePercentage)
	AS AnnualRevenueIncreasePercentage,
	AnnualRevenue,
	0.01 * AnnualRevenue * (
		SELECT AnnualRevenueIncreasePercentage
		FROM AnnualRevenueIncreasePercentage AS InnerQuery
		WHERE InnerQuery.GroupID = OuterQuery.GroupID
	)
	AS NewAnnualRevenue
FROM TheatreGroup AS OuterQuery;

DROP VIEW AnnualRevenueIncreasePercentage;

-- QUESTION 11

CREATE INDEX Dir_IDX ON TheatreGroup (Director);

-- QUESTION 12

SELECT
	GroupName,
	ROUND(
		AnnualRevenue / 12,
		2
	)
	AS MonthlyRevenue
FROM TheatreGroup
WHERE GroupID IN (
	300,
	700
);

-- QUESTION 13

SELECT
	Region.RegionName,
	TheatreGroup.GroupName,
	Performer.Surname AS DirectorSurname
FROM TheatreGroup
JOIN Performer ON TheatreGroup.Director = Performer.MembershipID
JOIN Region ON TheatreGroup.RegionID = Region.RegionID
WHERE DateStarted BETWEEN '2007-01-01' AND '2009-12-31';

-- QUESTION 14

SELECT
	TheatreGroup.GroupID,
	TheatreGroup.GroupName,
	COUNT(Performer.GroupID) AS MemberCount
FROM TheatreGroup
JOIN Performer ON TheatreGroup.GroupID = Performer.GroupID
GROUP BY
	TheatreGroup.GroupID,
	TheatreGroup.GroupName
HAVING COUNT(Performer.GroupID) > 5
ORDER BY COUNT(Performer.GroupID) DESC;

-- QUESTION 15(a)

SELECT TOP 1
	TheatreGroup.GroupID,
	TheatreGroup.GroupName,
	COUNT(Performer.GroupID) AS MemberCount
FROM TheatreGroup
JOIN Performer ON TheatreGroup.GroupID = Performer.GroupID
GROUP BY
	TheatreGroup.GroupID,
	TheatreGroup.GroupName
HAVING COUNT(Performer.GroupID) > 5
ORDER BY COUNT(Performer.GroupID) DESC;

-- QUESTION 15(b)

--SELECT
--	TheatreGroup.GroupID,
--	TheatreGroup.GroupName,
--	COUNT(Performer.GroupID) AS MemberCount
--FROM TheatreGroup
--JOIN Performer ON TheatreGroup.GroupID = Performer.GroupID
--GROUP BY
--	TheatreGroup.GroupID,
--	TheatreGroup.GroupName
--HAVING COUNT(Performer.GroupID) > 5
--ORDER BY COUNT(Performer.GroupID) DESC;

-- QUESTION 16

--SELECT
--	*
--FROM TheatreGroup
--JOIN Performer ON TheatreGroup.GroupID = Performer.GroupID
--JOIN PerformerSkill ON Performer.MembershipID = PerformerSkill.MembershipID
--JOIN Skill ON PerformerSkill.SkillID = Skill.SkillID
--WHERE SkillName <> 'Stage Combat'

-- QUESTION 17

SELECT
	Skill.SkillName,
	COUNT(PerformerSkill.MembershipID)
	AS PerformersWithSkill
FROM Skill
JOIN PerformerSkill ON Skill.SkillID = PerformerSkill.SkillID
JOIN Performer ON PerformerSkill.MembershipID = Performer.MembershipID
GROUP BY
	Skill.SkillName
HAVING
	COUNT(PerformerSkill.MembershipID) > 0;

-- QUESTION 18

UPDATE TheatreGroup
SET AnnualRevenue += 2000;


-- QUESTION 19

SELECT *
FROM TheatreGroup
ORDER BY GroupID DESC;

-- QUESTION 20

DELETE FROM Skill WHERE SkillID = 8;

-- QUESTION 21

SELECT *
FROM Skill
ORDER BY SkillID;

-- QUESTION 22

SELECT
	COUNT(*) AS PerformerCount
FROM Performer;

-- QUESTION 23

GO;

CREATE VIEW Directors AS
	SELECT
		Performer.MembershipID,
		Performer.FirstName,
		Performer.Surname
	FROM TheatreGroup
	JOIN Performer ON TheatreGroup.Director = Performer.MembershipID;
GO;

-- QUESTION 24

SELECT *
FROM Directors
ORDER BY MembershipID DESC;

-- QUESTION 25



-- QUESTION 26

--SELECT
--	GroupName,
--	FORMAT (DateStarted, 'mm yyyy') AS DateStarted
--FROM TheatreGroup
--ORDER BY DateStarted DESC;

-- QUESTION 27

SELECT
	GroupName,
	TheatreName
FROM TheatreGroup;

-- QUESTION 28



-- QUESTION 29



-- QUESTION 30

