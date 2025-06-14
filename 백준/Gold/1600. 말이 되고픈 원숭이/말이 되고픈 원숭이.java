import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int[][] map = new int[h][w];
        boolean[][][] visited = new boolean[h][w][k+1];
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, k, 0});
        visited[0][0][k] = true;
        
        int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
        int[] dxx = {1,2,2,1,-1,-2,-2,-1}, dyy = {2, 1, -1,-2,-2,-1,1,2};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int z = current[2];
            int cost = current[3];
            if (y == h-1 && x == w-1) {
                System.out.println(cost);
                return;
            }
            if (z > 0) {
                for (int i=0; i<8; i++) {
                    int ny = y + dyy[i];
                    int nx = x + dxx[i];
                    if (0<=ny && ny<h && 0<=nx && nx<w &&
                        map[ny][nx]==0 && !visited[ny][nx][z-1]) {
                        queue.add(new int[] {ny, nx, z-1, cost+1});
                        visited[ny][nx][z-1] = true;
                    }
                }
            }
            for (int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (0<=ny && ny<h && 0<=nx && nx<w &&
                    map[ny][nx]==0 && !visited[ny][nx][z]) {
                    queue.add(new int[] {ny, nx, z, cost+1});
                    visited[ny][nx][z] = true;
                }
            }
            
        }
        System.out.println(-1);
    }
}