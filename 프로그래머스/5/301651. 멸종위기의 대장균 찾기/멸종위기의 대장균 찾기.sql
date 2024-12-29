WITH RECURSIVE ECOLI AS (
    # 초기 설정(1세대)
    SELECT 
        ID, 
        PARENT_ID, 
        1 AS GENERATION
    FROM 
        ECOLI_DATA
    WHERE 
        PARENT_ID IS NULL
    UNION ALL
    # 재귀 설정(2세대 부터 계속, 데이터가 추가되지 않을때 까지 반복)
    SELECT 
        ed.ID,
        ed.PARENT_ID,
        e.GENERATION + 1 AS GENERATION
    FROM 
        ECOLI_DATA ed
    INNER JOIN 
        ECOLI e ON ed.PARENT_ID = e.ID
)
SELECT 
    COUNT(ID) AS COUNT,
    GENERATION
FROM 
    ECOLI
WHERE
    ID NOT IN (SELECT PARENT_ID FROM ECOLI WHERE PARENT_ID IS NOT NULL)
GROUP BY
    GENERATION
ORDER BY
    GENERATION