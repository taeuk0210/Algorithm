import java.util.stream.*;

class Solution {
    public int solution(int i, int j, int k) {
        return IntStream.rangeClosed(i, j).map(n -> count(n, k)).sum();
    }
    
    public int count(int n, int k) {
        int cnt = 0;
        while (n > 0) {
            if (n % 10 == k) cnt++;
            n /= 10;
        }
        return cnt;
    }
}