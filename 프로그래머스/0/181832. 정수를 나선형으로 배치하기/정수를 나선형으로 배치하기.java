class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        int x = -1;
        int y = 0;
        int dx = 1;
        int dy = 0;
        
        while (num <= n*n) {
            int nx = x + dx;
            int ny = y + dy;
            if (0 <= nx && nx < n && 0 <= ny && ny < n && answer[ny][nx] == 0) {
                answer[ny][nx] = num++;
                y = ny;
                x = nx;
            }
            else {
                if (dx == 1) {
                    dx = 0;
                    dy = -1;
                } else if (dy == -1) {
                    dx = -1;
                    dy = 0;
                } else if (dx == -1) {
                    dx = 0;
                    dy = 1;
                } else if (dy == 1) {
                    dx = 1;
                    dy = 0;
                }
            }         
        }
        return answer;
    }
}