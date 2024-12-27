-- 코드를 작성해주세요
SELECT
    he.EMP_NO,
    he.EMP_NAME,
    CASE
        WHEN hg.SCORE >= 96 THEN 'S'
        WHEN hg.SCORE >= 90 THEN 'A'
        WHEN hg.SCORE >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    CASE
        WHEN hg.SCORE >= 96 THEN he.SAL * 0.2
        WHEN hg.SCORE >= 90 THEN he.SAL * 0.15
        WHEN hg.SCORE >= 80 THEN he.SAL * 0.1
        ELSE he.SAL * 0.0
    END AS BONUS    
FROM
    (SELECT EMP_NO, AVG(SCORE) AS SCORE FROM HR_GRADE GROUP BY EMP_NO) hg
    INNER JOIN
    HR_EMPLOYEES he
    ON hg.EMP_NO = he.EMP_NO
ORDER BY
    EMP_NO