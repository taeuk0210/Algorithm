-- 코드를 입력하세요
SELECT
    CART_ID
FROM
    (
        SELECT
            CART_ID,
            NAME,
            COUNT(ID) AS CNT
        FROM    
            CART_PRODUCTS
        WHERE 
            NAME IN ('Yogurt', 'Milk')
        GROUP BY
            CART_ID,
            NAME
    ) c
GROUP BY
    CART_ID
HAVING
    COUNT(CART_ID) = 2

