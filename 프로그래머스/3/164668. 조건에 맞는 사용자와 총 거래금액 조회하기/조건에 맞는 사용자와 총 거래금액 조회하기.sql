-- 코드를 입력하세요
SELECT
    USER_ID,
    NICKNAME,
    u2.TOTAL_SALES
FROM 
    USED_GOODS_USER u1 INNER JOIN (
        SELECT
            ugb.WRITER_ID,
            SUM(ugb.PRICE) AS TOTAL_SALES
        FROM 
            USED_GOODS_BOARD  ugb
        WHERE 
            ugb.STATUS = 'DONE'
        GROUP BY
            ugb.WRITER_ID
        HAVING
            SUM(ugb.PRICE) >= 700000
    ) u2
    ON u1.USER_ID = u2.WRITER_ID
ORDER BY
    u2.TOTAL_SALES
