-- 코드를 입력하세요
SELECT
    CATEGORY,
    SUM(bs.SALES) AS TOTAL_SALES
FROM 
    BOOK b INNER JOIN BOOK_SALES bs
    ON b.BOOK_ID = bs.BOOK_ID
WHERE
    MONTH(bs.SALES_DATE) = 1
GROUP BY
    b.CATEGORY
ORDER BY
    b.CATEGORY
    