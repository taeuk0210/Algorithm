import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int[] arr;
        for (int side=1; side < sides[0]+sides[1]; side++) {
            arr = new int[] {side, sides[0], sides[1]};
            Arrays.sort(arr);
            if (arr[2] < arr[0] + arr[1]) answer++; 
        }
        return answer;
    }
}