-- INNER JONIS -----------------------------------------------------------------------------------
-- Query 1
SELECT
	sale.order_no,
	sale.order_value,
	company.name
FROM sale
JOIN company ON sale.company_no = company.company_no;