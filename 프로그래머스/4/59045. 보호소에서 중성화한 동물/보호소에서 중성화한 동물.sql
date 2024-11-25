-- 코드를 입력하세요
SELECT
    ai.ANIMAL_ID,
    ai.ANIMAL_TYPE,
    ai.NAME
FROM 
    ANIMAL_INS ai INNER JOIN ANIMAL_OUTS ao
    ON ai.ANIMAL_ID = ao.ANIMAL_ID
WHERE
    (ai.SEX_UPON_INTAKE NOT LIKE 'Spayed%' AND
    ai.SEX_UPON_INTAKE NOT LIKE 'Neutered%')
    AND
    (ao.SEX_UPON_OUTCOME LIKE 'Spayed%' OR
    ao.SEX_UPON_OUTCOME LIKE 'Neutered%')