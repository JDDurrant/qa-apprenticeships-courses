-- 1 Sales Perople With Quarterly Targets

SELECT		lname, sales_target / 4 'Quarterly Target'
FROM		salesperson
ORDER BY 	'Quarterly Target' DESC

-- 2 Sales Peoples EmpNo DeptNo And Initials

SELECT 	emp_no,
	dept_no,
	SUBSTRING(fname,1,1) + '.' + SUBSTRING(lname,1,1) 'Initials'
FROM 	salesperson

-- 3 Employee Numbers Of Sale People Who Have Sold Something

SELECT	DISTINCT emp_no
FROM 	sale

-- 4 Sales whose Order values in the range 10 to 30

SELECT 	*
FROM 	sale
WHERE	order_value between 10 and 30

-- 5 Sales whose Order values in the range 10 to 30 by employee 10 and 50

SELECT 	*
FROM 	sale
WHERE	order_value BETWEEN 10 and 30
AND	    emp_no IN (10, 50)

-- 6 Departments whose name contains sys and no barbara banana

SELECT 	*
FROM 	dept
WHERE 	(dept_name LIKE '%SYS%' OR sales_target < 10)
AND 	manager <> 'Barbara Banana'

-- 7 Sales People, Dept No and County combinations

SELECT	DISTINCT dept_no, county
FROM 	salesperson

-- 8 Monthly Numbers of the Sales that have been made

SELECT DATEPART(month, order_date) as month
FROM sale
ORDER BY month 

-- 9 Telephone numbers that start with 0207

SELECT	name, tel
FROM 	contact
WHERE	SUBSTRING(tel,1,5) LIKE '%0207%' 

-- 10 Sales Made in May and July

SELECT 	order_no, order_date
FROM	sale
WHERE	DATEPART(mm,order_date) IN (5,7)

-- 11 Sales People WIth a Non Null Postcode

SELECT	emp_no, post_code
FROM 	salesperson
WHERE 	post_code IS NOT NULL

-- 12 All Sales People Hightlighting those with Null post codes

SELECT emp_no, COALESCE(post_code, 'Post Code Unknown') AS Postcode
FROM   salesperson

-- 13 Sales Peoples Post Codes That are Not RT8 8LP

SELECT	emp_no, post_code
FROM 	salesperson
WHERE  post_code <> 'RT8 8LP' OR post_code Is NULL

-- 14 The highest order

SELECT TOP 1 emp_no, order_no, order_value
FROM sale
ORDER BY order_value DESC

-- 15 The lowest two orders (and ties)

SELECT TOP 2 WITH TIES emp_no, order_no, order_value
FROM sale
ORDER BY order_value 

-- 16 Combining output

SELECT order_no, emp_no, order_value, order_value * 2 as NewOrderValue
FROM sale
WHERE emp_no = 10
UNION
SELECT order_no, emp_no, order_value, order_value * 3 as NewOrderValue
FROM sale
WHERE emp_no = 60
UNION
SELECT order_no, emp_no, order_value, order_value as NewOrderValue
FROM sale
WHERE emp_no NOT IN (10,60)

-- 17 Ordering the combined output

SELECT order_no, emp_no, order_value, order_value * 2 as NewOrderValue
FROM sale
WHERE emp_no = 10
UNION
SELECT order_no, emp_no, order_value, order_value * 3 as NewOrderValue
FROM sale
WHERE emp_no = 60
UNION
SELECT order_no, emp_no, order_value, order_value as NewOrderValue
FROM sale
WHERE emp_no NOT IN (10,60)
ORDER BY emp_no, NewOrderValue

-- 18 Using CASE

SELECT order_no, emp_no, order_value,
   CASE emp_no
	WHEN 10 THEN order_value * 2
	WHEN 60 THEN order_value * 3
	ELSE order_value
   END AS NewOrderValue
FROM sale
ORDER BY emp_no, NewOrderValue
