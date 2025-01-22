import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = Arrays.stream(array)
            .boxed()
            .sorted((a,b)->a-b)
            .mapToInt(Integer::intValue)
            .toArray()[array.length/2];
        return answer;
    }
}