import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        boolean isBooked;
        List<Integer> rooms = new ArrayList<>();
        
       List<int[]> times = Arrays.stream(book_time)
            .map((time) -> {
                int[] output = new int[2];
                for (int i = 0; i < 2; i++) {
                    String[] hm = time[i].split(":");
                    output[i] = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
                }
                return output;
            })
            .sorted((a, b) -> Integer.compare(a[0], b[0]))
            .collect(Collectors.toList());

        
        for (int[] time : times) {
            isBooked = false;
            for (int i=0; i<rooms.size(); i++) {
                if (rooms.get(i) + 10 <= time[0]) {
                    rooms.set(i, time[1]);
                    isBooked = true;
                    break;
                }
            }
            if (!isBooked) rooms.add(time[1]);
        }
        answer = rooms.size();
            
        return answer;
    }
}