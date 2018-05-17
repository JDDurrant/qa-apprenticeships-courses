-- 4 Departments with more than 1 person

SELECT 	dept_name
FROM	salesperson SP JOIN dept D
		ON SP.dept_no = D.dept_no
GROUP BY dept_name
HAVING 	COUNT(*) > 1

-- 5 Count of the number of contacts per company

SELECT 	COMP.name, COUNT(*) AS 'TotalContacts'
FROM 	company COMP JOIN contact CONT
	ON COMP.company_no = CONT.company_no
GROUP BY COMP.name

-- 6 Count of the number of contacts per company 
--   including companies with no contacts

INSERT INTO company
VALUES (5000, 'ABC Ltd(no contacts)', '(01456)346782', 'Dorset', 'ST8 3RG')

----Wrong solution (total contacts dispalys as '1')
SELECT 	COMP.name, count(*) 'TotalContacts'
FROM 	company COMP LEFT JOIN contact CONT
	ON COMP.company_no = CONT.company_no
GROUP BY COMP.name

SELECT 	COMP.name, count(CONT.company_no) 'TotalContacts'
FROM 	company COMP LEFT JOIN contact CONT
	ON COMP.company_no = CONT.company_no
GROUP BY COMP.name

-- 7 Create View of count of the number of contacts per company
--   including companies with no contacts

CREATE VIEW NoOfContacts 
AS
SELECT 	COMP.name, COUNT(CONT.company_no) 'TotalContacts'
FROM 	company COMP LEFT JOIN contact CONT
	ON COMP.company_no = CONT.company_no
GROUP BY COMP.name

-- 8 View based descending count of the number of contacts per company
--   including companies with no contacts

SELECT  * 
FROM 	NoOfContacts
ORDER BY TotalContacts desc

-- 9 Total sales by employee per company

SELECT company_no, emp_no, SUM(order_value) 'Total sales'
FROM sale
GROUP BY company_no, emp_no
ORDER BY company_no, emp_no