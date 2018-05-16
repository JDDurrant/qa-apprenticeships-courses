-- SIMPLE QUERIES --------------------------------------------------------------------------------
-- List all records from a table.
SELECT * FROM company;		-- Clients
SELECT * FROM contact;		-- Client contacts
SELECT * FROM dept;			-- Departments
SELECT * FROM sale;			-- Sales records
SELECT * FROM salesperson;	-- Employees in sales

-- QUERIES WITH JOINS ----------------------------------------------------------------------------
-- List all sales people and the details of their departments.
SELECT * FROM salesperson
JOIN dept ON salesperson.dept_no = dept.dept_no;

-- QUERIES WITH SPECIFIC FIELDS ------------------------------------------------------------------
-- List all sales people in Surrey.
SELECT
	fname AS 'First name',
	lname AS 'Surname',
	tel AS 'Landline number'
FROM salesperson
WHERE county = 'Surrey';

-- List various details of each sales person, including their department and manager.
SELECT
	salesperson.fname AS 'First name',
	salesperson.lname AS 'Surname',
	salesperson.tel AS 'Landline number',
	dept.manager AS 'Manager',
	dept.dept_name AS 'Department',
	COALESCE(salesperson.notes, '') AS 'Notes'
FROM salesperson
JOIN dept ON salesperson.dept_no = dept.dept_no;

-- List various details of each sale, including the sales person's name.
SELECT
	sale.order_no AS 'Order no.',
	sale.description AS 'Item description',
	sale.order_value AS 'Price ($)',
	salesperson.fname + ' ' + salesperson.lname AS 'Salesperson'
FROM sale
JOIN salesperson ON sale.emp_no = salesperson.emp_no;

-- List various details of each sale, including the sales person's name, ordered by sale value.
SELECT
	sale.order_no AS 'Order no.',
	sale.description AS 'Item description',
	sale.order_value AS 'Price ($)',
	salesperson.fname + ' ' + salesperson.lname AS 'Salesperson'
FROM sale
JOIN salesperson ON sale.emp_no = salesperson.emp_no
ORDER BY sale.order_value DESC;

-- List various details of top three most valuable sales.
SELECT TOP 3
	sale.order_no AS 'Order no.',
	sale.description AS 'Item description',
	sale.order_value AS 'Price ($)',
	salesperson.fname + ' ' + salesperson.lname AS 'Salesperson'
FROM sale
JOIN salesperson ON sale.emp_no = salesperson.emp_no
ORDER BY sale.order_value DESC;

-- List various details of top 50% most valuable sales.
SELECT TOP 50 PERCENT
	sale.order_no AS 'Order no.',
	sale.description AS 'Item description',
	company.name AS 'Client',
	'$' + CAST(sale.order_value AS VARCHAR) AS 'Price',
	salesperson.fname + ' ' + salesperson.lname AS 'Salesperson'
FROM sale
JOIN company ON sale.company_no = company.company_no
JOIN salesperson ON sale.emp_no = salesperson.emp_no
ORDER BY sale.order_value DESC;

INSERT INTO dept
	(dept_no, dept_name, manager, sales_target)
VALUES
	(6, 'Test department', 'Manager', 50);

DELETE FROM dept WHERE dept_no = 6;

SELECT * FROM salesperson
RIGHT JOIN dept ON salesperson.dept_no = dept.dept_no;