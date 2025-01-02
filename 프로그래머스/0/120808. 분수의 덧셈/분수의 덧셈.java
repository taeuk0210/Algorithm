class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        answer[0] = numer1*denom2 + numer2*denom1;
        answer[1] = denom1 * denom2;
        
        int gcd = getGCD(answer[0], answer[1]);
        answer[0] /= gcd;
        answer[1] /= gcd;
        return answer;
    }
    public int getGCD(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}