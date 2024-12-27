-- 코드를 작성해주세요
SELECT
    h.SCORE,
    h.EMP_NO,
    e.EMP_NAME,
    e.POSITION,
    e.EMAIL
FROM
    HR_EMPLOYEES e
    INNER JOIN
    (SELECT 
        SUM(SCORE) AS SCORE,
        EMP_NO
    FROM
        HR_GRADE
    WHERE
        YEAR = 2022
    GROUP BY
        EMP_NO
    ORDER BY
        SUM(SCORE) DESC
    LIMIT 1) h
    ON e.EMP_NO = h.EMP_NO

