-- 1 Sum and Average of sales_targets and salespeople count

SELECT 	SUM(sales_target) Total,
		AVG(sales_target) Average,
		COUNT(*) 'No of sales people'
FROM	salesperson

-- 2 Sum and Average of sales_targets and salespeople count per Dept

-- You may not have deleted the salesperson you added earlier
--DELETE FROM salesperson WHERE emp_no=70

SELECT 	dept_no,
		SUM(sales_target) Total,
		AVG(sales_target) Average,
		COUNT(*) 'No of sales people'
FROM	salesperson
GROUP BY dept_no

-- 3 SUm and Average of sales_targets and salespeople count per named dept

SELECT 	SP.dept_no,
		dept_name,
		SUM(SP.sales_target) Total,
		AVG(SP.sales_target) Average,
		COUNT(*) 'No of sales people'
FROM	salesperson SP JOIN dept D
		ON SP.dept_no = D.dept_no
GROUP BY SP.dept_no, dept_name
