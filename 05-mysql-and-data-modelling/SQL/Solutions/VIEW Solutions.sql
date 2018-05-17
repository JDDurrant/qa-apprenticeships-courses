-- 1 Create London View

CREATE VIEW London
AS
SELECT company_no, name, county
FROM company
WHERE county = 'London'
WITH CHECK OPTION

-- 2 Select using London View

SELECT company_no, name, county
FROM London

-- 3 Create London view with post code

ALTER VIEW London
AS
SELECT company_no, name, post_code, county
FROM company
WHERE county = 'London'
WITH CHECK OPTION

-- 4 Select using London View with post code

SELECT  name, post_code
FROM London
WHERE post_code LIKE 'N%'
ORDER BY post_code ASC

-- 5 Insert that should fail

INSERT INTO London
VALUES (5000, 'ABC CO', 'RF45 7GH', 'ESSEX')