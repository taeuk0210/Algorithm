import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] dices = new int[] {a,b,c,d};
        Map<Integer, Integer> result = new HashMap<>();
        
        for (int dice : dices) {
            if (result.containsKey(dice)) {
                result.put(dice, result.get(dice)+1);
            } else {
                result.put(dice, 1);
            }
        }
        
        if (result.size() == 1) {
            for (int key : result.keySet()) {
                answer = 1111 * key;
            }
        } else if (result.size() == 4) {
            answer = 6;
            for (int key : result.keySet()) {
                if (answer > key) answer = key;
            }
        } else if (result.size() == 3) {
            answer = 1;
            for (int key : result.keySet()) {
                if (result.get(key) == 1) {
                    answer *= key;
                }
            }
        } else {
            answer = 1;
            for (int key : result.keySet()) {
                answer *= result.get(key);
            }
            if (answer == 3) {
                int p = 0;
                int q = 0;
                for (int key : result.keySet()) {
                    if (result.get(key) == 3) p = key;
                    if (result.get(key) == 1) q = key;
                }
                answer = (10 * p + q) * (10 * p + q);
            } else {
                int[] pq = new int[2];
                int i = 0;
                for (int key: result.keySet()) {
                    pq[i] = key;
                    i++;
                }
                answer = (pq[0] + pq[1]) * Math.abs(pq[0]-pq[1]);
            }
        }
        
        return answer;
    }
}