import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        boolean[][][] visited = new boolean[n][m][k+1];
        char[][] map = new char[n][m];
        for (int i=0; i<n; i++) {
            map[i] = sc.nextLine().toCharArray();
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0,k,1});
        visited[0][0][k] = true;
        
        int[] dx = {-1,0,1,0}, dy={0,-1,0,1};
        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int z = current[2];
            int cost = current[3];
            if (y == n-1 && x == m-1) {
                System.out.println(cost);
                return;
            }
            if (z > 0) {
                for (int i=0; i<4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (0<=ny && ny<n && 0<=nx && nx<m && !visited[ny][nx][z-1]) {
                        queue.offer(new int[] {ny, nx, z-1, cost+1});
                        visited[ny][nx][z-1] = true;
                    }
                }
            }
            for (int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (0<=ny && ny<n && 0<=nx && nx<m && !visited[ny][nx][z] && map[ny][nx]=='0') {
                    queue.offer(new int[] {ny, nx, z, cost+1});
                    visited[ny][nx][z] = true;
                }
            }
        }
        System.out.println(-1);
    }
}