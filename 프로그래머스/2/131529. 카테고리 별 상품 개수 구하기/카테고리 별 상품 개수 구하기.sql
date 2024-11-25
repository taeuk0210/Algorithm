-- 코드를 입력하세요
SELECT 
    p.CATEGORY,
    COUNT(p.PRODUCT_ID)
FROM (
    SELECT 
        PRODUCT_ID, 
        SUBSTRING(PRODUCT_CODE, 1, 2) AS CATEGORY
    FROM PRODUCT) p
GROUP BY p.CATEGORY
ORDER BY p.CATEGORY


