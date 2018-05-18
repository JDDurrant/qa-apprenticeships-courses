-- Name : PUT YOUR NAME HERE

-- # NOTES
-- GO statements are used to silence syntax errors and should not be executed. In Microsoft SQL Server Management Studio,
-- highlight a snippet of code and press F5 to execute just that snippet.

SELECT * FROM Countries;
SELECT * FROM Departments;
SELECT * FROM Employees;
SELECT * FROM Job_History;
SELECT * FROM Jobs;
SELECT * FROM Locations;
SELECT * FROM Regions;

GO;

-- QUESTION 1 

SELECT
	Last_Name,
	First_Name -- ,
--	Hire_Date --> Uncomment while testing
FROM Employees
WHERE Hire_Date <= '1991-05-21 23:59:59.999';

GO;

-- QUESTION 2

SELECT
	Department_No,
	Last_Name,
	Annual_Salary -- ,
--	Hire_Date --> Uncomment while testing
FROM Employees
WHERE Hire_Date
	BETWEEN	'1987-09-16 00:00:00.000'
	AND		'1996-05-12 23:59:59.999'
ORDER BY
	Department_No,
	Last_Name;

GO;

-- QUESTION 3

SELECT *
FROM Jobs
WHERE Max_Salary > 15000;

GO;

-- QUESTION 4

SELECT
	Last_Name,
	First_Name,
	Job_ID,
	Commission_Percent
FROM Employees
WHERE Commission_Percent > 0
ORDER BY Commission_Percent ASC;

GO;

-- QUESTION 5

SELECT
	DISTINCT Jobs.Job_Title,
	Departments.Department_Name
FROM Jobs
JOIN Employees ON Jobs.Job_ID = Employees.Job_ID
JOIN Departments ON Employees.Department_No = Departments.Department_No
WHERE Departments.Department_Name IN (
	'IT',
	'Sales'
);

GO;

-- QUESTION 6

SELECT
	Last_Name,
	ROUND(Annual_Salary / 12, 2) AS Monthly_Salary,
	Department_No
FROM Employees
WHERE Department_No IN (
	50,
	90
)
ORDER BY Last_Name ASC;

GO;

-- QUESTION 7

SELECT
	ROUND (
		SUM(Annual_Salary) / 12,
		0
	)
	AS Total_Monthly_Salary
FROM Employees;

GO;

-- QUESTION 8

SELECT
	COUNT (*)
	AS Total_Employees
FROM Employees;

GO;

-- QUESTION 9

SELECT
	Departments.Department_No,
	Departments.Department_Name,
	COUNT(Employees.Employee_No)
	AS No_Of_Employees
FROM Departments
JOIN Employees ON Departments.Department_No = Employees.Department_No
GROUP BY
	Departments.Department_No,
	Departments.Department_Name
HAVING COUNT(Employees.Employee_No) > 2;

GO;

-- QUESTION 10

SELECT TOP 1
	Departments.Department_No,
	Departments.Department_Name,
	COUNT(Employees.Employee_No)
	AS No_Of_Employees
FROM Departments
JOIN Employees ON Departments.Department_No = Employees.Department_No
GROUP BY
	Departments.Department_No,
	Departments.Department_Name
ORDER BY COUNT(Employees.Employee_No) DESC;

GO;

-- QUESTION 11

SELECT
	DISTINCT Departments.Department_No,
	Departments.Department_Name
FROM Departments
JOIN Employees ON Departments.Department_No = Employees.Department_No
JOIN Jobs ON Employees.Job_ID = Jobs.Job_ID
WHERE Departments.Department_No NOT IN (
	SELECT
		Departments.Department_No
	FROM Departments
	JOIN Employees ON Departments.Department_No = Employees.Department_No
	JOIN Jobs ON Employees.Job_ID = Jobs.Job_ID
	WHERE Jobs.Job_Title IN (
		'Programmer'
	)
);

GO;

-- QUESTION 12

INSERT INTO Jobs (
	Job_ID,
	Job_Title,
	Min_Salary,
	Max_Salary
) VALUES (
	'IT_ANAL',
	'System Analyst',
	10000,
	15000
);

SELECT * FROM Jobs;

GO;

-- SELECT * FROM Jobs; --> Uncomment while testing

-- QUESTION 13

SELECT * FROM Jobs;

UPDATE Jobs
SET Max_Salary += 1000;

SELECT * FROM Jobs;

GO;

-- SELECT * FROM Jobs; --> Uncomment while testing

-- QUESTION 14

SELECT *
FROM Jobs
ORDER BY Job_ID ASC;

GO;

-- QUESTION 15(a)

DELETE FROM Job_History
WHERE Employee_No = 102;

GO;

-- QUESTION 15(b)

SELECT * FROM Job_History;

GO;

-- QUESTION 16

CREATE VIEW Employee_Raises AS
	SELECT
		Employee_No,
		CASE
			WHEN Department_No IN (10, 20)
			THEN 5.0
			WHEN Department_No IN (50, 80, 90, 110)
			THEN 10.0
			ELSE 0.0
		END
		AS Percentage_Raise
	FROM Employees;
GO;

SELECT
	Employee_Raises.Percentage_Raise,
	Employees.Employee_No,
	Employees.Annual_Salary,
	Employees.Annual_Salary + Employees.Annual_Salary * (Employee_Raises.Percentage_Raise / 100)
	AS New_Annual_Salary
FROM Employees
JOIN Employee_Raises ON Employees.Employee_No = Employee_Raises.Employee_No;

DROP VIEW Employee_Raises;

GO;

-- QUESTION 17

CREATE VIEW Manager_Details AS
	SELECT
		Employees.Employee_No AS Manager_No,
		Employees.First_Name AS Manager_First_Name,
		Employees.Last_Name AS Manager_Last_Name,
		Departments.Department_No,
		Departments.Department_Name
	FROM Departments
	JOIN Employees ON Departments.Manager_ID = Employees.Employee_No
	WITH CHECK OPTION;
GO;

-- QUESTION 18

SELECT *
FROM Manager_Details
ORDER BY Manager_No ASC;

GO;

-- QUESTION 19

GRANT SELECT
ON Manager_Details
TO PUBLIC;

GO;

-- QUESTION 20

CREATE INDEX LOC_POSTAL_CODE
ON Locations (Postal_Code);

SELECT * FROM Locations WITH (INDEX(LOC_POSTAL_CODE));

GO;