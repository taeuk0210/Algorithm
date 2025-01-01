import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for (int e : array) {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }
        
        int maxCount = 0;
        for (int key : map.keySet()) {
            if (maxCount < map.get(key)) {
                list = new ArrayList<>();
                list.add(key);
                maxCount = map.get(key);
            } else if (maxCount == map.get(key)) {
                list.add(key);
            }
        }
        
        
        int answer = list.size() == 1 ? list.get(0) : -1;
        return answer;
    }
}