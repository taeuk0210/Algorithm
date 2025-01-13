class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer;
        int n = arr.length;
        int m = arr[0].length;
        int b = n >= m ? n : m;
        
        answer = new int[b][b];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                answer[i][j] = arr[i][j]; 
            }
        }
        return answer;
    }
}