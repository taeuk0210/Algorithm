-- 코드를 입력하세요
SELECT
    b.TITLE,
    r.BOARD_ID,
    r.REPLY_ID,
    r.WRITER_ID,
    r.CONTENTS,
    DATE_FORMAT(r.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM
    USED_GOODS_BOARD b
    RIGHT JOIN
    USED_GOODS_REPLY r
    ON b.BOARD_ID = r.BOARD_ID
WHERE
    LEFT(b.CREATED_DATE, 7) = '2022-10'    
ORDER BY
    r.CREATED_DATE,
    b.TITLE