SELECT
    ID, EMAIL, FIRST_NAME, LAST_NAME
FROM
    DEVELOPERS
WHERE EXISTS (
    SELECT 1
    FROM (SELECT CODE FROM SKILLCODES WHERE NAME IN ('Python', 'C#')) pc
    WHERE SKILL_CODE & pc.CODE = pc.CODE)
ORDER BY
    ID