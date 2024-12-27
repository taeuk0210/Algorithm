SELECT
    c.CAR_ID,
    CASE
        WHEN MAX(c.AVAILABILITY) = 1 THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM
    (SELECT
        CAR_ID,
        CASE
            WHEN START_DATE <= DATE('2022-10-16') AND
                END_DATE >= DATE('2022-10-16') THEN 1
            ELSE 0
        END AS AVAILABILITY
    FROM
        CAR_RENTAL_COMPANY_RENTAL_HISTORY) c
GROUP BY
    c.CAR_ID
ORDER BY
    c.CAR_ID DESC
    