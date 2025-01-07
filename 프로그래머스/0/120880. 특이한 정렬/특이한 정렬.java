import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        
        int[] answer = Arrays.stream(numlist)
            .boxed()
            .sorted((a, b) -> {
                int c = (Math.abs(a-n) == Math.abs(b-n)) ? b - a : Math.abs(a-n) - Math.abs(b-n);
                return c;
            })
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}