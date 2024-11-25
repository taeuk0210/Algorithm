-- 코드를 입력하세요
SELECT 
    animal_type,
    CASE
        WHEN name is NULL THEN 'No name'
        ELSE name
        END AS NAME,
    SEX_UPON_INTAKE 
FROM animal_ins