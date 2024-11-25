-- 코드를 작성해주세요
SELECT 
    fg.ID,
    fni.FISH_NAME,
    fg.LENGTH
FROM 
    FISH_NAME_INFO fni
    INNER JOIN
    (
        SELECT 
            fi.ID,
            fi.FISH_TYPE,
            fi.LENGTH
        FROM
            FISH_INFO fi
        WHERE (FISH_TYPE, LENGTH) IN (
            SELECT FISH_TYPE, MAX(LENGTH)
            FROM FISH_INFO 
            GROUP BY FISH_TYPE
        )       
    ) fg
    ON fni.FISH_TYPE = fg.FISH_TYPE
ORDER BY fg.ID
