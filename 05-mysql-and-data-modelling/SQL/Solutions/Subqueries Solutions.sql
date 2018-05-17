-- 1 Sales person with the biggest sales target

SELECT 	fname, lname
FROM 	salesperson 
WHERE 	sales_target =
        (
		SELECT 	MAX(sales_target) 
		FROM 	salesperson
		)

SELECT TOP 1 WITH TIES fname, lname
FROM salesperson
ORDER BY sales_target DESC

-- 2 The number of people who have sold

SELECT 	COUNT(*)
FROM    salesperson
WHERE 	emp_no IN
	(
	SELECT emp_no
	FROM   sale
	)

--OR
SELECT COUNT(DISTINCT emp_no)
FROM   sale 


-- 3 Sales target and total sales of each salesperson

SELECT fname, lname, sales_target, sum(order_value) 'Sales achieved'
FROM salesperson SP LEFT JOIN sale S
  ON SP.emp_no = S.emp_no 
GROUP BY fname,	lname,	sales_target 

-- 4 Sales target and total sales of each salesperson using coalesce

SELECT fname, lname, sales_target, COALESCE(SUM(order_value),0) 'Sales achieved'
FROM salesperson SP LEFT JOIN sale S
  ON SP.emp_no = S.emp_no
GROUP BY fname,	lname,	sales_target


-- 5 Does total sales achieved by all sales staff exceed the total of all their sales targets 

SELECT fname, lname, sales_target, COALESCE(SUM(order_value),0) 'Sales achieved'
FROM salesperson SP LEFT JOIN sale S
  ON SP.emp_no = S.emp_no
WHERE EXISTS
  (
    -- after running the inner code 
    -- sum(sales_target) will contain some data, 
    -- so the EXISTS above will be true and the
    -- Outer Query will run
    SELECT sum(sales_target)   -- SUM(sales_target) is 66
    FROM salesperson
    -- total of sales_targets is produced second
    HAVING sum(sales_target) >
    (
      -- this nested query runs first
      SELECT sum(order_value)   -- SUM(order_value) is 65
      FROM sale
    )
  ) 
GROUP BY fname, lname, sales_target

-- 6 Staff who have missed their sales target

SELECT	fname,	lname,	sales_target, COALESCE(SUM(order_value),0) 'Sales achieved'
FROM salesperson SP LEFT JOIN sale S
  ON SP.emp_no = S.emp_no
WHERE 	EXISTS
	(SELECT SUM(sales_target) 
	 FROM salesperson
	 HAVING SUM(sales_target) >
		(SELECT SUM(order_value)
		 FROM sale
		)
	)
GROUP BY SP.emp_no, fname, lname, sales_target
HAVING sales_target > COALESCE(SUM(order_value),0) 

-- 7 Or with emp_no's in the select

SELECT SP.emp_no, fname, lname, sales_target, 
       --------*           -- column added
COALESCE(SUM(order_value),0) 'Sales achieved'
FROM salesperson SP LEFT JOIN sale S
  ON SP.emp_no = S.emp_no
WHERE 	EXISTS
  (
    SELECT SUM(sales_target) 
    FROM salesperson
    HAVING SUM(sales_target) >
    (
        SELECT SUM(order_value)
        FROM sale
    )
  )
GROUP BY SP.emp_no, fname, lname, sales_target
HAVING sales_target > COALESCE(SUM(order_value),0)


-- 8 staff who have missed their sales targets without using EXISTS

SELECT	SP.emp_no, fname, lname, sales_target,	COALESCE(SUM(order_value),0) 'Sales achieved'
FROM 	salesperson SP LEFT JOIN sale S
	ON SP.emp_no = S.emp_no
WHERE 	
	(SELECT sum(sales_target) FROM salesperson)
        >
	(SELECT sum(order_value) FROM sale)

GROUP BY SP.emp_no, fname, lname, sales_target
HAVING sales_target > COALESCE(SUM(order_value),0)

-- 9 Top 2 sales people

SELECT TOP 2 WITH TIES fname, lname, sales_target
FROM salesperson
ORDER BY sales_target DESC

-- You can base your question on percentages:

SELECT TOP 35 PERCENT WITH TIES fname, lname, sales_target
FROM salesperson
ORDER BY sales_target DESC
