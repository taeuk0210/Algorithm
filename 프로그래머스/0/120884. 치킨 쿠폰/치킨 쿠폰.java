class Solution {
    public int solution(int chicken) {
        int coupon = chicken;
        int answer = 0;
        int amount;
        while (coupon >= 10) {
            amount = coupon/10;
            answer += amount;
            coupon %= 10;
            coupon += amount;
        }
        return answer;
    }
}