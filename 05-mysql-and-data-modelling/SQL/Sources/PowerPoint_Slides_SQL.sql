SELECT  emp_no, fname, lname, dept_no   -- all columns
FROM salesperson
---------------------------------------------------
SELECT   company_no, name, county FROM company
---------------------------------------------------
SELECT  lname, sales_target * 1.2 AS 'Next Year'
FROM salesperson
---------------------------------------------------
SELECT  emp_no, sales_target + sales_target * 0.03 'Total sales target'  FROM salesperson
---------------------------------------------------
SELECT  emp_no, sales_target + (sales_target * 0.03) 'Total sales target'  FROM salesperson
---------------------------------------------------
SELECT  fname + ' ' + lname AS 'FullName' FROM salesperson
---------------------------------------------------
SELECT   order_no, SUBSTRING (description, 1, 15 ) AS Short_Desc FROM sale
----------------------------------------------------------------------------
print GETDATE ( )
SELECT DATENAME(year, '2014/04/28');
----------------------------------------------------------------------------

SELECT  order_no, DATEPART (qq, order_date ) AS qtr_sold FROM sale  -- (MS SQL Server)

year		--> yy, yyyy
quarter 	--> qq, q
month		--> mm, m
dayofyear 	--> dy, y
day		    --> dd, d
week		--> wk, ww
weekday		--> dw, w
hour		--> hh
minute		--> mi, n
second		--> ss, s
millisecond	--> ms
microsecond	--> mcs
nanosecond	--> ns

select * from salesperson
select emp_no, coalesce(notes,'No notes entered') FROM salesperson
---------------------------------------------------
SELECT  DISTINCT dept_no, emp_no FROM salesperson
---------------------------------------------------
SELECT	* FROM 	contact ORDER BY company_no DESC, name
---------------------------------------------------
SELECT	company_no AS C_no FROM contact ORDER BY C_no DESC, name
---------------------------------------------------
SELECT * FROM sale WHERE order_value < 25
---------------------------------------------------
SELECT * FROM salesperson WHERE sales_target BETWEEN 100 AND 500
---------------------------------------------------
SELECT * FROM salesperson WHERE sales_target >= 100 AND sales_target <= 500
---------------------------------------------------
SELECT fname FROM salesperson 
WHERE fname IN ('Tom', 'Dick', 'Harry')

-- It would be safer if we use UPPER to avoid the case sensetivity problem
SELECT fname FROM salesperson WHERE UPPER(fname) IN ('TOM', 'DICK', 'HARRY')

-- easier than coding 
SELECT fname FROM salesperson
WHERE Upper(fname) = 'TOM' OR 
      UPPER(fname) = 'DICK' OR
      UPPER(fname) ='HARRY'
---------------------------------------------------
SELECT fname FROM salesperson WHERE fname NOT IN (‘Tom’, ‘Dick’, ‘Harry’)
---------------------------------------------------
SELECT lname FROM salesperson WHERE UPPER(lname) LIKE 'D%'
---------------------------------------------------
SELECT lname FROM salesperson WHERE UPPER(lname) LIKE '%R'
---------------------------------------------------
SELECT lname FROM salesperson WHERE UPPER(lname) LIKE 'D_%R'
---------------------------------------------------
SELECT lname FROM salesperson WHERE UPPER(lname) LIKE '_U%T%D'
---------------------------------------------------
SELECT 	* FROM 	salesperson WHERE county = 'Surrey' AND fname = 'Smith'
---------------------------------------------------
SELECT 	* FROM 	salesperson WHERE county = 'Surrey' OR fname = 'Smith'
---------------------------------------------------
SELECT TOP 6 WITH TIES order_no, order_value FROM sale ORDER BY order_value DESC
---------------------------------------------------
SELECT lname, sales_target, sales_target*2 AS NewTarget FROM salesperson 
WHERE sales_target < 10
UNION -- removes dublication
SELECT lname, sales_target, sales_target/2 FROM salesperson 
WHERE sales_target > 10
---------------------------------------------------
SELECT lname, sales_target FROM salesperson 
WHERE lname LIKE '%I%'
UNION ALL  -- keeps dublication
SELECT lname, sales_target FROM salesperson 
WHERE lname LIKE '%E%'
---------------------------------------------------
SELECT
	CASE lname
		WHEN 'Brick' 	THEN 'Ok'
		WHEN 'Custard' 	THEN 'ZZZ'
		WHEN 'Digger' 	THEN 'Interesting'
		WHEN 'Ernst' 	THEN 'ZZZ' 
		ELSE 'Not yet categorised ' + lname
	END as Category, 
	fname
FROM  salesperson
ORDER BY Category
---------------------------------------------------
SELECT
	CASE 
	WHEN lname IN ('Custard', 'Ernst') THEN 'ZZZ'
	WHEN lname IN ('Digger') THEN 'Interesting' 
	WHEN lname IN ('Brick') THEN 'Ok'    
	ELSE 'Not yet categorised ' + lname     
END AS Category, fname,    
	
	CASE 
	WHEN sales_target < 4 THEN 'low'                
	WHEN sales_target < 10 THEN 'medium'                
	WHEN sales_target BETWEEN 20 AND 30 THEN 'high'                 
	ELSE 'Not defined'     
END AS TargetStatus FROM salesperson ORDER by Category
---------------------------------------------------
SELECT 	* FROM 	salesperson WHERE notes IS NULL
---------------------------------------------------
select left(fname, 1) + '.' + left(lname, 1) as 'init' from salesperson 
------------------------------------------------------
select upper(fname) from salesperson 
--------------------------------------------------------
select lower(fname) from salesperson 
-------------------------------------------------------

SELECT 'SYSDATETIME()      ', SYSDATETIME();
SELECT 'SYSDATETIMEOFFSET()', SYSDATETIMEOFFSET();
SELECT 'SYSUTCDATETIME()   ', SYSUTCDATETIME();
SELECT 'CURRENT_TIMESTAMP  ', CURRENT_TIMESTAMP;
SELECT 'GETDATE()          ', GETDATE();
SELECT 'GETUTCDATE()       ', GETUTCDATE();
/* Returned:
SYSDATETIME()            2007-05-03 18:34:11.9351421
SYSDATETIMEOFFSET()      2007-05-03 18:34:11.9351421 -07:00
SYSUTCDATETIME()         2007-05-04 01:34:11.9351421
CURRENT_TIMESTAMP        2007-05-03 18:34:11.933
GETDATE()                2007-05-03 18:34:11.933
GETUTCDATE()             2007-05-04 01:34:11.933
*/

print GETDATE()

print CAST(GETDATE()  AS Date) 

print CONVERT(Date, GETDATE())

select order_date = CONVERT(varchar(20), Order_Date, 103),  -- UK Date format
	   order_date = CONVERT(varchar(20), Order_Date, 106)   -- dd MON yy format
from sale 
---------------------------------------------------
select CHARINDEX ('Sep', notes) as 'CHI' from salesperson 

select PATINDEX ('%ep%', notes) as 'PI' from salesperso
--------------------------------------------------------
SELECT lname, manager
FROM salesperson JOIN dept
ON salesperson.dept_no = dept.dept_no

-- even easier

SELECT SP.dept_no, lname, manager
FROM 	  salesperson SP JOIN dept D
ON          SP.dept_no = D.dept_no

-- same as

SELECT SP.dept_no, dept_name, lname
FROM salesperson  SP INNER JOIN dept D
ON SP.dept_no = D.dept_no
---------------------------------------------------
SELECT SP.dept_no, dept_name, lname
FROM sale S 
JOIN salesperson SP ON S.emp_no = SP.emp_no
JOIN dept D ON SP.dept_no = D.dept_no
JOIN company C ON C.company_no = S.company_no
---------------------------------------------------
SELECT 	C.name, S.*                   
FROM sale S JOIN contact C
ON S.company_no    = C.company_no
AND S.contact_code = C.contact_code
---------------------------------------------------
SELECT 	SP1.county, SP1.fname, SP1.lname, 
SP2.fname, SP2.lnameFROM salesperson SP1 
JOIN salesperson SP2ON SP1.county = SP2.county
WHERE 	SP1.emp_no > SP2.emp_no
---------------------------------------------------
SELECT county, fname, lnameFROM salesperson ORDER BY county
---------------------------------------------------
SELECT county, fname, lname, dept.dept_noFROM salesperson CROSS JOIN dept

select fname from salesperson
select dept_no from dept
---------------------------------------------------
SELECT lname, manager
FROM salesperson SP INNER JOIN dept D 
ON SP.dept_no = D.dept_no 
---------------------------------------------------
SELECT lname, manager
FROM salesperson SP right OUTER JOIN dept D
ON SP.dept_no = D.dept_no

SELECT lname, manager
FROM salesperson SP Left OUTER JOIN dept D
ON SP.dept_no = D.dept_no
---------------------------------------------------
SELECT lname, manager
FROM salesperson SP right OUTER JOIN dept D
ON SP.dept_no = D.dept_no WHERE SP.dept_no is NULL
---------------------------------------------------
CHARACTER Fixed 	length character data.  Normally abbreviated to CHAR, max size will vary by DBMS.
CHARACTER VARYING 	Variable length character data.  Normally shortened to VARCHAR, max size will vary by DBMS.
BIT			Fixed length binary data
BIT VARYING		Variable length binary data.
NUMERIC, DECIMAL	Accurate decimal numbers, usually BCD encoded.
INTEGER			Usually 32-bit whole numbers.  Range + or – approximately 2 thousand million.
SMALLINT		Usually 16-bit whole numbers.  Range + or - 32 K
FLOAT			Floating point, approximate numbers.
DATE			Dates in the format yyyy-mm-dd
TIME			Times in the format hh:mm:ss.sssss
TIMESTAMP		A very accurate date and time combined together guaranteed to be unique within the DBMS.
			Used by application programs to implement optimistic concurrency.			
INTERVAL		A period between two timestamps.

niladic functions (system functions that take no arguments) which include:

CURRENT_TIMESTAMP   -- Oracle uses SYSDATE 
select CURRENT_TIMESTAMP as Current_Time_Stamp;
-----------------------------------
SELECT GETDATE() AS CurrentDateTime;
print GETDATE();
-------------------------------------
CREATE TABLE Orders
(
	OrderId int NOT NULL PRIMARY KEY,
	ProductName varchar(50) NOT NULL,
	OrderDate datetime NOT NULL DEFAULT GETDATE()
)
--------------------------------------
CURRENT_TIME
CURRENT_TIMESTAMP   -- Oracle uses SYSDATE 
USER

CREATE TABLE dept
(
	dept_no		SMALLINT 	NOT NULL,
	dept_name	CHAR(12) 	NOT NULL UNIQUE,
	manager	 	CHAR(20) 	NULL,
	sales_target	DECIMAL(8, 2)	DEFAULT 50000.00 CHECK(SALES_TARGET BETWEEN 20000 AND 99000)	
)


---------------------------------------------------
CREATE TABLE contact
	(
	company_no		INTEGER	 		NOT NULL,
	contact_code	CHAR(3)			NOT NULL,
	name			VARCHAR(20)		NULL,
	job_title		VARCHAR(25)		NULL,
	tel				VARCHAR(20)		NULL,
	notes			VARCHAR(60)     NULL, 

	PRIMARY KEY (company_no, contact_code),
	FOREIGN KEY (comany_no) REFERENCES  company
	)
p
---------------------------------------------------
select * from dept
ALTER TABLE dept ADD location CHAR(30) NULL
---------------------------------------------------
ALTER TABLE sale ALTER order_value DROP DEFAULT
---------------------------------------------------
ALTER TABLE salesperson DROP sales_target
---------------------------------------------------
CREATE [UNIQUE] INDEX name ON table_name ( col1 [ASC | DESC], ....,	coln)
Example:-
	CREATE INDEX idx_seller ON sale (emp_no)

---------------------------------------------------
CREATE VIEW  company_sales
AS
SELECT 	COMP.name AS 'Company_Name',
	   	CONT.name AS 'Contact_Name',  S.* 
FROM 		company COMP JOIN contact CONT
		ON COMP.company_no = CONT.company_no
		JOIN sale S
		ON 	S.company_no = CONT.company_no
		AND 	S.contact_code = CONT.contact_code


SELECT 	*  FROM company_sales ORDER BY emp_no
---------------------------------------------------
GRANT SELECT ON phone_list TO PUBLIC
GRANT INSERT, UPDATE, DELETE ON phone_list TO hr-users
---------------------------------------------------
GRANT ALL ON dept TO John
GRANT SELECT ON dept TO PUBLIC
GRANT SELECT, UPDATE, INSERT ON dept TO John, Chris, Sean
---------------------------------------------------
REVOKE privilege ON tablename | viewname FROM grantees
e.g 	REVOKE SELECT ON dept FROM Sally
---------------------------------------------------
--View 
CREATE VIEW  company_sales
AS
SELECT 	COMP.name AS 'Company_Name',
	   	CONT.name AS 'Contact_Name',  S.* 
FROM 		company COMP JOIN contact CONT
		ON COMP.company_no = CONT.company_no
		JOIN sale S
		ON 	S.company_no = CONT.company_no
		AND 	S.contact_code = CONT.contact_code



delete from company_sales where company_sales.Company_name =  'Judo Jeans PLC' -- error

update company_sales set Company_name =  'Judo Jeans' 
where  company_sales.Company_name =  'Judo Jeans' AND contact_code = 'MM'   -- o row is effected

update company_sales set Company_name =  'Judo Jeans' 
where  company_sales.Company_name =  'Judo Jeans plc' -- updates because just one table is engaged


----------

CREATE VIEW dept3_staff AS SELECT *  FROM salesperson WHERE dept_no = 3
select * from dept3_staff

INSERT INTO dept3_staff
VALUES (90, 'BOB','SMITH', 4, 20000, null, null, null, null)

select * from dept3_staff

INSERT INTO dept3_staff
VALUES (90, 'BOB','SMITH', 4, 20000, null, null, null, null)  ---  Duplicate Primary Key Violation

select * from salesperson

delete from dept3_staff where emp_no = 90  -- 0 row is effected 
delete from salesperson where emp_no = 90  -- 1 row effected 

INSERT INTO dept3_staff
VALUES (90, 'BOB','SMITH', 3, 20000, null, null, null, null)

select * from dept3_staff

select * from employee
---------------

CREATE VIEW empupdate AS 
SELECT * FROM employee WHERE id BETWEEN 1000 AND 20000
AND salary BETWEEN 5000 AND 100000
AND dept IN (123,124,125,126,127, 450, 451, 452, 453)
WITH CHECK OPTION
---------------------------------------------------
Aggregate functions:

SELECT Count(AVG(sales_target)) FROM salesperson  -- nesting of aggregate functions is illegal
-------
select COUNT(sales_target) from salesperson
select SUM(sales_target) from salesperson
select AVG(sales_target) from salesperson
select MIN(sales_target) from salesperson
select MAX(sales_target) from salesperson
-------
SELECT emp_no, avg(order_value) as Average, sum(order_value) as Sum, 
count(order_value) as Count 
FROM sale GROUP BY emp_no
-------
SELECT		emp_no,  SUM(order_value) 
FROM 		sale
WHERE 		emp_no BETWEEN 30 AND 50 AND order_value  > 10000
GROUP BY 	emp_no
HAVING 	SUM(order_value) > 40000
-------
SELECT		emp_no,  SUM(order_value) 
FROM 		sale
WHERE 		emp_no BETWEEN 30 AND 60 AND order_value  > 10
GROUP BY 	emp_no
HAVING 	SUM(order_value) > 20
-------		
 --is it works?
SELECT		emp_no,  SUM(order_value) 
FROM 		sale
WHERE 		emp_no BETWEEN 30 AND 60 AND order_value  > 10 AND SUM(order_value) > 20
GROUP BY 	emp_no
-----------------------------------------------------------
subqueries:

SELECT 	* 
FROM 	salesperson
WHERE 	dept_no IN 
    (   SELECT 	dept_no
	FROM 	dept
	WHERE 	dept_name LIKE 'Lo%'
    )
-----
SELECT 	fname, dept_no
FROM 	salesperson
WHERE 	dept_no IN 
	( SELECT 	dept_no
	FROM 	dept
	WHERE 	dept_name LIKE 'Bu%'
	)
----
SELECT 	order_no, order_date, order_value
FROM		sale
WHERE	order_value = MIN(order_value)     -- does it work?
-----
SELECT 	emp_no, order_date, order_value
FROM sale
where order_value = ( select min(order_value) from sale) -- it works now
-------
SELECT 	order_no, order_date, order_value
FROM		sale
Group by order_date
having	order_value = MIN(order_value)     -- does it work?
------
SELECT 	* FROM 	dept
WHERE EXISTS
	(SELECT	'FRED'
	 WHERE 	40 > 10)   -- always true
-----
SELECT 	* FROM 	dept
WHERE EXISTS
	(SELECT	'FRED'
	 WHERE 	10 > 40)       -- always false
----
SELECT 	* FROM 	salesperson
WHERE EXISTS
	(SELECT	* from sale where salesperson.emp_no = sale.emp_no)   -- all the salespersons who sold sold something 
----
SELECT 	* FROM 	salesperson
WHERE NOT EXISTS
	(SELECT	* from sale where salesperson.emp_no = sale.emp_no)   -- all the salespersons who didn't sel anything
------------------------------------------------------  
Correlated queries

-- inner query runs first, brackets should be removed first 

SELECT * FROM sale
WHERE order_value =
	(
	SELECT MAX(order_value)
	FROM    sale	
	)

---------

SELECT 	company_no, MAX(order_value), emp_no
FROM		sale
GROUP BY	company_no    -- invalid code
--------
SELECT 	company_no, MAX(order_value), emp_no
FROM		sale
GROUP BY	company_no, emp_no    -- gives biggest sale per company per employee
--------

SELECT 	company_no, order_value, emp_no
FROM 	sale
WHERE	order_value IN
	(SELECT MAX(order_value) FROM sale
	 GROUP BY company_no)    -- gives biggest sale per company ()
------
-- Add a new record to sale 
INSERT [dbo].[sale] ([order_no], [emp_no], [their_order_no], [company_no], [contact_code], [order_value], [order_date], [description]) VALUES (900, 60, N'B-123E', 3000, N'RR ', 12, CAST(0x0000900900000000 AS DateTime), N'Printer cartridges2')
-- run the previous query again
SELECT 	company_no, order_value, emp_no
FROM 	sale
WHERE	order_value IN
	(SELECT MAX(order_value) FROM sale
	 GROUP BY company_no)    -- the company with company_no 3000 with order_value 12 is selected although is not the highest sale
------
-- solusion, top down execution
SELECT 	 company_no, order_value, emp_no
FROM  sale S1             -- (S1 alias required)
WHERE order_value = 
	(SELECT 	MAX(order_value)
	 FROM	sale S2 
	 WHERE 	S2.company_no = S1.company_no)
-----

SELECT * FROM sale AS S JOIN (SELECT company_no, max(order_value) 'Biggest'
FROM sale
GROUP BY company_no) AS SUMM
ON  S.company_no  = SUMM.company_no
AND S.order_value = SUMM.Biggest       -- joining on both columns
ORDER BY S.company_no
-----

SELECT	dept_no
FROM 	dept D
WHERE NOT EXISTS
	(SELECT 	* 
	 FROM 	salesperson SP
	 WHERE 	SP.dept_no = D.dept_no) 

----
SELECT	dept_no
FROM 	dept D
WHERE	dept_no NOT IN (SELECT  dept_no FROM salesperson) 


-- Another example

SELECT 	* FROM 	salesperson SP
WHERE EXISTS
	(SELECT	* from sale S1 where SP.emp_no = S1.emp_no 
	and S1.order_value = (select max(order_value) from sale))



