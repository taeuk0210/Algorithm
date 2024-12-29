WITH GRADECODES AS (
    SELECT
        'A' AS GRADE,
        CODE + (SELECT CODE FROM SKILLCODES WHERE NAME='Python') AS CODE
    FROM
        SKILLCODES
    WHERE
        CATEGORY = 'Front End'
    UNION
    SELECT
        CASE
            WHEN CATEGORY = 'Back End' THEN 'B'
            ELSE 'C'
        END AS GRADE,
        CODE
    FROM
        SKILLCODES
    WHERE
        CATEGORY = 'Front End' OR NAME = 'C#'
)
SELECT
    MIN(GRADE) AS GRADE,
    ID,
    EMAIL
FROM
    DEVELOPERS d
JOIN
    GRADECODES g ON d.SKILL_CODE & g.CODE = g.CODE
GROUP BY
    ID, EMAIL
ORDER BY
    GRADE, ID