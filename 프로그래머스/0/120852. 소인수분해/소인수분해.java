import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer;
        int d = 2;
        List<Integer> list = new ArrayList<>();
        while (n > 1) {
            if (n % d == 0) {
                list.add(d);
                while (n%d == 0) n /= d;
            } else {
                d++;
            }
        }
        answer = list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}