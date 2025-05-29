import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        int[] s = new int[2];
        int[] e = new int[2];
        int[] l = new int[2];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    s = new int[] {i, j};
                }
                if (maps[i].charAt(j) == 'E') {
                    e = new int[] {i, j};
                }
                if (maps[i].charAt(j) == 'L') {
                    l = new int[] {i, j};
                }
            }
        }
        
        int answer = 0;
        int t = bfs(s, l, maps);
        if (t == -1) {
            return t;
        }
        answer += t;
        t = bfs(l, e, maps);
        if (t == -1) {
            return t;
        }
        answer += t;
        return answer;
    }
    
    private int bfs(int[] start, int[] end, String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int y, x, ny, nx, d;
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, -1, 0, 1};
        int[] current;
        
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1], 0});
        
        while (!queue.isEmpty()) {
            current = queue.poll();
            y = current[0];
            x = current[1];
            d = current[2];
            if (maps[y].charAt(x) == maps[end[0]].charAt(end[1])) {
                return d;
            }
            
            for (int i=0; i<4; i++) {
                ny = y + dy[i];
                nx = x + dx[i];
                if (0<=ny && ny<n && 0<=nx && nx<m) {
                    if (maps[ny].charAt(nx) != 'X' && !visited[ny][nx]) {
                        queue.offer(new int[] {ny, nx, d+1});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return -1;
    }
}