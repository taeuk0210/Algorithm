import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        int[] result = IntStream.range(0, rank.length)
            .boxed()
            .filter(i -> attendance[i])
            .sorted((i, j) -> rank[i]-rank[j])
            .mapToInt(Integer::intValue)
            .toArray();
        
        for (int i=0; i<3; i++) {
            answer += result[i]*Math.pow(100, 2-i);
        }
        return answer;
    }
}