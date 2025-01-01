class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int q = total / num;
        int r = total % num;
        for (int i=0; i<num; i++) {
            if (r == 0) {        
                answer[i] = q - ((num - 1) / 2) + i;
            } else {
                answer[i] = q - (num / 2 - 1) + i;
            } 
        }
        
        return answer;
    }
}