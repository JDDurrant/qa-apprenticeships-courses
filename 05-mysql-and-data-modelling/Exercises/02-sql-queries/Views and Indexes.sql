--CREATE VIEW employee_department_view WITH SCHEMABINDING AS
--	SELECT
--		dbo.salesperson.emp_no,
--		dbo.salesperson.fname AS fname,
--		dbo.salesperson.lname AS lname,
--		dbo.salesperson.tel AS tel,
--		dbo.dept.manager AS manager,
--		dbo.dept.dept_name AS dept,
--		COALESCE(dbo.salesperson.notes, '') AS notes
--	FROM dbo.salesperson
--	JOIN dbo.dept ON dbo.salesperson.dept_no = dbo.dept.dept_no;
--GO;

--DROP VIEW employee_department_view;

SELECT * FROM employee_department_view;

CREATE UNIQUE CLUSTERED INDEX employee_tel_index ON employee_department_view(tel);
CREATE UNIQUE CLUSTERED INDEX employee_department_index ON employee_department_view(dept);

SELECT * FROM employee_department_view employee_tel_index ORDER BY tel;