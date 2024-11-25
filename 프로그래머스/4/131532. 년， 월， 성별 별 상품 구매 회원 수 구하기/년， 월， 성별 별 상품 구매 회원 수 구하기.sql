-- 코드를 입력하세요
SELECT 
    YEAR(sales_date) as YEAR,
    MONTH(sales_date) as MONTH,
    gender as GENDER,
    count(distinct ui.user_id) as USERS
FROM 
    ONLINE_SALE os INNER JOIN
    (SELECT user_id, gender FROM USER_INFO WHERE gender IS NOT NULL) ui
    ON ui.user_id = os.user_id
group by YEAR(sales_date), MONTH(sales_date), gender
order by YEAR(sales_date), MONTH(sales_date), gender