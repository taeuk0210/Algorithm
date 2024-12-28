
SELECT
    ID,
    CASE 
        WHEN Q = 1 THEN 'LOW'
        WHEN Q = 2 THEN 'MEDIUM'
        WHEN Q = 3 THEN 'HIGH'
        ELSE 'CRITICAL'
    END AS COLONY_NAME
FROM
    (SELECT
        ID,
        NTILE(4) OVER (ORDER BY SIZE_OF_COLONY) AS Q
    FROM
        ECOLI_DATA) q
ORDER BY    
    ID

