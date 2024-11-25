-- 코드를 입력하세요
SELECT price DIV 10000 * 10000, count(distinct product_id) FROM product
GROUP BY price DIV 10000