class Solution {
    public long solution(int n) {
        long f0 = 0;
        long f1 = 1;
        long tmp = 1;
        for (int i = 2; i <= n; i++) {
            tmp = f0 + f1;
            f0 = f1;
            f1 = tmp%1234567;
        }
        return f1%1234567;
    }
}