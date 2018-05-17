-- 1 - Sales person name

SELECT 
	emp_no, 
	LEFT(fname, 1) + ' ' + lname AS name
FROM 
	salesperson

-- 2 - County in upper case

SELECT 
	emp_no, 
	LEFT(fname, 1) + ' ' + lname AS name, 
	UPPER(county) AS county
FROM 
	salesperson


-- 3 - extract year, month and day

SELECT 
	order_no, 
	YEAR(order_date) AS order_year, 
	MONTH(order_date) AS order_month, 
	DAY(order_date) AS order_day
FROM 
	sale


-- 4 - Increased sales target

SELECT
	dept_no, 
	sales_target * 1.638 AS new_target
FROM 
	dept

-- 5 - rounded sales target to 1 decimal places

SELECT
	dept_no, 
	ROUND(sales_target * 1.638,1) AS new_target
FROM 
	dept

-- 6 - rounded sales target to no decimal places

SELECT
	dept_no, 
	ROUND(sales_target * 1.638,0) AS new_target
FROM 
	dept

-- 7 - sales target displayed with no decimal places (no rounding)

SELECT
	dept_no, 
	CAST(sales_target * 1.638 AS int) AS new_target
FROM 
	dept

-- or

SELECT
	dept_no, 
	CONVERT(int, sales_target * 1.638) AS new_target
FROM 
	dept
