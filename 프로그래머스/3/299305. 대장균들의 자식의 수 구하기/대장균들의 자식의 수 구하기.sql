-- 코드를 작성해주세요

SELECT
    ID,
    IFNULL(CHILD_COUNT, 0) AS CHILD_COUNT
FROM 
    ECOLI_DATA ed
    LEFT JOIN
    (
        SELECT
            PARENT_ID,
            COUNT(PARENT_ID) AS CHILD_COUNT
        FROM
            ECOLI_DATA
        WHERE
            PARENT_ID IS NOT NULL
        GROUP BY
            PARENT_ID
    ) p
    ON ed.ID = p.PARENT_ID
ORDER BY
    ID
    