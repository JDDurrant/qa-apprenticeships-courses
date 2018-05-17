-- 1 Three Select Statements

SELECT 	dept_no, manager 
FROM dept

SELECT DISTINCT dept_no AS 'Distinct list of depts that people are in'
FROM salesperson

SELECT D.dept_no, manager, lname
FROM salesperson SP INNER JOIN dept D
	                 ON SP.dept_no = D.dept_no


-- 2 Right Outer and Coalesce

SELECT D.dept_no, manager, lname
FROM salesperson SP RIGHT JOIN dept D
	ON SP.dept_no = D.dept_no

SELECT D.dept_no, manager, COALESCE(lname, 'Nobody in this dept') as Surname
FROM salesperson SP RIGHT JOIN dept D
	ON SP.dept_no = D.dept_no

-- 3 Finding Monica

INSERT INTO salesperson(emp_no, fname, lname, dept_no)
VALUES (70, 'Monica', 'Ell', NULL)

-- The following INNER JOIN query will not discover her
SELECT manager, COALESCE(lname, 'Nobody in this dept') AS Surname
FROM salesperson SP INNER JOIN dept D
	                 ON SP.dept_no = D.dept_no

-- Nor will this Outer JOIN
SELECT manager, COALESCE(lname, 'Nobody in this dept') AS Surname 
FROM salesperson SP RIGHT JOIN dept D
	                 ON SP.dept_no = D.dept_no

-- But this one will, note dept D RIGHT JOIN salesperson SP 
SELECT COALESCE(manager,'Has no manager') AS Manager, lname
FROM dept D RIGHT JOIN salesperson SP
	         ON SP.dept_no = D.dept_no

-- 4 Full Join

SELECT COALESCE(manager, '** Has no manager **')      AS Manager, 
       COALESCE(lname,   '** Empty dept **') AS Surname
FROM dept D FULL JOIN salesperson SP
	         ON SP.dept_no = D.dept_no


SELECT COALESCE(STR(D.dept_no,2),'N/A') AS Dept_no, 
       COALESCE(manager,'** Has no manager **') AS Manager, 
       COALESCE(lname,'** Empty dept **') AS Surname
FROM dept D FULL JOIN salesperson SP
	         ON SP.dept_no = D.dept_no

-- 5 Where Clause and Left Join

SELECT D.dept_no, 
       COALESCE(manager,'** Has no manager **') AS Manager, 
       COALESCE(lname,'** Nobody in this dept **') AS Surname
FROM   dept D LEFT JOIN salesperson SP
	           ON SP.dept_no = D.dept_no
WHERE  SP.dept_no IS NULL

-- Classic Error
SELECT D.dept_no, 
       COALESCE(manager,'** Has no manager **') AS Manager, 
       COALESCE(lname,'** Nobody in this dept **') AS Surname
FROM   dept D LEFT JOIN salesperson SP
	           ON SP.dept_no = D.dept_no
WHERE  SP.post_code IS NULL  -- no good, must be a primary key(not NULL) column for safety
