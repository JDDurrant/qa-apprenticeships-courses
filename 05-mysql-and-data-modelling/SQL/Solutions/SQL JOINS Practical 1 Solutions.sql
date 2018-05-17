-- 1 Order Number, Value and Company Name

SELECT 	order_no, order_value, name
FROM 	sale S INNER JOIN company C
	    ON S.company_no = C.company_no
ORDER BY name

-- 2 Sales Person, Department and Sales Info

SELECT 	fname, lname, dept_no, order_value, [description]
FROM	sale S INNER JOIN salesperson SP
	    ON S.emp_no = SP.emp_no

-- 3 Emp no, sales person, Department and Sales Info

SELECT 	SP.emp_no, fname, lname, dept_no, order_value, [description]
FROM	sale S INNER JOIN salesperson SP
	ON S.emp_no = SP.emp_no
ORDER BY SP.emp_no

-- 4 Manager, Emp no, sales person, Department and Sales Info

SELECT 	D.manager, SP.emp_no, fname, lname, D.dept_no, order_value, [description]
FROM 	sale S 
INNER JOIN salesperson SP ON S.emp_no = SP.emp_no
INNER JOIN dept D ON D.dept_no = SP.dept_no

--restricted to descriptions that contain the word printer
SELECT 	D.manager, SP.emp_no, fname, lname, D.dept_no, order_value, [description]
FROM 	sale S 
INNER JOIN salesperson SP ON S.emp_no = SP.emp_no
INNER JOIN dept D ON D.dept_no = SP.dept_no
WHERE 	[description] LIKE '%printer%'

-- 5 Contacts and their company name

SELECT	CONT.name 'Contact', COMP.name 'Company'
FROM 	contact CONT 
INNER JOIN company COMP	ON CONT.company_no = COMP.company_no

-- 6 Big Sales Phone Contact Details

SELECT 	manager, C.name, C.tel 
FROM  	
dept D 
INNER JOIN salesperson SP ON D.dept_no = SP.dept_no
INNER JOIN sale S ON SP.emp_no = S.emp_no
INNER JOIN contact C ON  C.company_no   = S.company_no
		AND C.contact_code = S.contact_code
WHERE order_value > .5 * SP.sales_target
