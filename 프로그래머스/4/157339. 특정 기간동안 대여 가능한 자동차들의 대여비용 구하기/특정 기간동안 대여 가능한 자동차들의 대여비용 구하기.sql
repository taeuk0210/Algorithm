SELECT
    c.CAR_ID,
    c.CAR_TYPE,
    ROUND(c.DAILY_FEE * 30 * (1-d.DISCOUNT_RATE*0.01)) AS FEE    
FROM
    (SELECT CAR_ID, CAR_TYPE, DAILY_FEE
     FROM CAR_RENTAL_COMPANY_CAR
    WHERE NOT EXISTS (
         SELECT 1
         FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
         WHERE 
             CAR_ID = CAR_RENTAL_COMPANY_CAR.CAR_ID AND 
             NOT (
                 END_DATE < DATE('2022-11-01') OR 
                 START_DATE > DATE('2022-11-30')
             )
     )
    ) c
JOIN
    (SELECT CAR_TYPE, DISCOUNT_RATE
     FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
     WHERE DURATION_TYPE = '30일 이상') d
    ON c.CAR_TYPE = d.CAR_TYPE
WHERE
    (c.CAR_TYPE IN ('세단', 'SUV')) AND
    (c.DAILY_FEE * 30 * (1-d.DISCOUNT_RATE*0.01) BETWEEN 500000 AND 2000000)
ORDER BY
    FEE DESC,
    CAR_TYPE,
    CAR_ID DESC
# SELECT
#     *
# FROM
#     CAR_RENTAL_COMPANY_RENTAL_HISTORY 
# WHERE
#     CAR_ID IN (
#         SELECT CAR_ID
#         FROM CAR_RENTAL_COMPANY_CAR
#         WHERE CAR_TYPE IN ('SUV', '세단'))
# ORDER BY
#     CAR_ID