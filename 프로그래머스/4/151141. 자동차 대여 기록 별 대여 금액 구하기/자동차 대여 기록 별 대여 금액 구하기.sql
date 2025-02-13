-- 코드를 입력하세요
SELECT
    HISTORY_ID,
    ROUND(MIN(
        (DATEDIFF(h.END_DATE, h.START_DATE)+1) * 
        DAILY_FEE * 
        (1-IFNULL(DISCOUNT_RATE, 0)*0.01)
    )) AS FEE
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY h
LEFT JOIN
    CAR_RENTAL_COMPANY_CAR c
    ON h.CAR_ID = c.CAR_ID
LEFT JOIN
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN d
    ON c.CAR_TYPE = d.CAR_TYPE
    AND DATEDIFF(h.END_DATE, h.START_DATE)+1 >=
        REPLACE(d.DURATION_TYPE, '일 이상', '')
WHERE 
    c.CAR_TYPE = '트럭'
GROUP BY
    HISTORY_ID
ORDER BY
    FEE DESC,
    HISTORY_ID DESC
    