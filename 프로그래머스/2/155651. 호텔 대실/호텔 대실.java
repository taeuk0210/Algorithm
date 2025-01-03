import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        boolean isBooked;
        int[][] times = new int[book_time.length][2];
        List<Integer> rooms = new ArrayList<>();
        
        for (int i=0; i<book_time.length; i++) {
            for (int j=0; j<2; j++) {
                times[i][j] = str2int(book_time[i][j]);
            }
        }
        
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        
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
    
    public int str2int(String time) {
        String[] hm = time.split(":");
        return Integer.parseInt(hm[0])*60 + Integer.parseInt(hm[1]);
    }
}