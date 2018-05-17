-- Exercise 1
SELECT
	fname,
	lname
FROM salesperson
WHERE sales_target = (
	SELECT
		MAX(sales_target)
	FROM salesperson
);

-- Exercise 2
SELECT emp_no AS 'employees' FROM salesperson; --> Returns a list of each employee's emp_no field

SELECT emp_no AS 'employees who have made sales' FROM sale
ORDER BY emp_no --> Returns a list of employee numbers for employees who have made sales

SELECT 	COUNT(*)
FROM    salesperson
WHERE 	emp_no IN (
	SELECT emp_no
	FROM   sale
);
-- Equivalent to:
SELECT COUNT(DISTINCT emp_no)
FROM sale;

-- Exercise 3
SELECT
	salesperson.fname,
	salesperson.lname,
	salesperson.sales_target,
	SUM(sale.order_value) AS total_sales_value,
	CASE WHEN SUM(sale.order_value) >= salesperson.sales_target
		THEN 'Yes'
		ELSE 'No'
	END
	AS met_sales_target
FROM salesperson
JOIN sale ON salesperson.emp_no = sale.emp_no
GROUP BY salesperson.fname, salesperson.lname, salesperson.sales_target;