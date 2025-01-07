import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        int n;
        boolean isOk;
        for (int i=l; i<=r; i++) {
            isOk = true;
            n = i;
            while (n > 0) {
                if (n % 10 != 0 && n % 10 != 5) {
                    isOk = false;
                    break;
                }
                n /= 10;
            }
            if (isOk) list.add(i);
        }
        int[] answer = list.size() == 0 ? new int[] {-1} : list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}