import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = 1;
        while(true) {
            int n = sc.nextInt();

            if (n == 0) {
                break;
            }

            solve(n, sc, p++);
        }
    }

    public static void solve(int n, Scanner sc, int p) {
        int[] current, dy={-1,0,1,0}, dx={0,-1,0,1};
        int y,x,ny,nx,cost;

        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, map[0][0]});
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            current = pq.poll();
            y = current[0];
            x = current[1];
            cost = current[2];
            for (int i = 0; i < 4; i++) {
                ny = y + dy[i];
                nx = x + dx[i];
                if (0<=ny && ny<n && 0<=nx && nx<n && !visited[ny][nx]) {
                    map[ny][nx] += cost;
                    visited[ny][nx] = true;
                    pq.offer(new int[]{ny,nx,map[ny][nx]});
                }
            }
        }
        System.out.println("Problem "+p+": "+map[n-1][n-1]);
    }
}
