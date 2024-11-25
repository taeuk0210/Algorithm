SELECT
    ID,
    EMAIL,
    FIRST_NAME,
    LAST_NAME
FROM
    DEVELOPERS d
WHERE 
    EXISTS (
        SELECT 1
        FROM SKILLCODES s
        WHERE s.CATEGORY = 'Front End'
        AND (
            (LENGTH(BIN(d.SKILL_CODE)) - LENGTH(REPLACE(BIN(d.SKILL_CODE), '1', ''))) - 
            (LENGTH(BIN(d.SKILL_CODE - s.CODE)) - LENGTH(REPLACE(BIN(d.SKILL_CODE - s.CODE), '1', ''))) = 1
        )
    )
ORDER BY ID