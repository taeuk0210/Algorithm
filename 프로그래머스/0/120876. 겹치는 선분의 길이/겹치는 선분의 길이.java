class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int s = 101;
        int e = -101;
        for (int i=0; i<3; i++) {
            if (lines[i][0] < s) s = lines[i][0];
            if (lines[i][1] > e) e = lines[i][1];
        }
        
        int[] m = new int[e-s];
        for (int[] line : lines) {
            for (int i=line[0]; i<line[1]; i++) {
                m[i-s] += 1;
            }
        }
        
        for (int i=0; i<m.length; i++) {
            if (m[i] > 1) answer++;
        }
        return answer;
    }
    
}