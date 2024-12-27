-- 코드를 입력하세요
SELECT
    CONCAT_WS(
        '/',
        '/home/grep/src',
        BOARD_ID,
        CONCAT(
            FILE_ID,
            FILE_NAME,
            FILE_EXT
        )
    ) AS FILE_PATH
FROM 
    USED_GOODS_FILE
WHERE
    BOARD_ID IN (
        SELECT
            BOARD_ID
        FROM 
            USED_GOODS_BOARD
        WHERE
            VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)    
    )
ORDER BY
    FILE_ID DESC
