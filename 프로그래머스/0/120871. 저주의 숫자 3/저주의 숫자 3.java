class Solution {
    public int solution(int n) {
        int answer = 1;
        int count = 1;
        while (count <= n) {
            if (isValid(answer)) {
                answer++;
                count++;
            } else {
                answer++;
            }
            
        }
        return answer-1;
    }
    public boolean isValid(int n) {
        boolean isValid = true;
        if (n % 3 == 0) return false;
        while (n > 0) {
            if (n  % 10 == 3) {
                isValid = false;
                break;
            }
            n /= 10;
        }
        return isValid;
    }
}