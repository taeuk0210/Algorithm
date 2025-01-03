import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Long> weightMap = new HashMap<>();
        
        for (int i=0; i<weights.length; i++) {
            if (weightMap.containsKey(weights[i])) {
                weightMap.put(weights[i], weightMap.get(weights[i])+1);
            } else {
                weightMap.put(weights[i], (long)1);
            }
        }
        
        for (int w1 : weightMap.keySet()) {
            answer += weightMap.get(w1) * (weightMap.get(w1)-1) / 2;
            for (int w2 : weightMap.keySet()) {
                if (w1 > w2) {
                    if (w1 == 2*w2 || 2*w1 == 3*w2 || 3*w1 == 4*w2) {
                        answer += weightMap.get(w1) * weightMap.get(w2);
                    } 
                }
            }
        }
        return answer;
    }
}