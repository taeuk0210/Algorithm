import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] m = new int[N][M];
        int[][] d = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                m[i][j] = sc.nextInt();
                if (m[i][j] == 1) {
                    q.offer(new int[] { i, j });
                    d[i][j] = 0;
                }
            }
        }

        int[] current, dx={-1,0,1,0}, dy = {0, -1, 0, 1};
        int y, x, ny, nx;
        while (!q.isEmpty()) {
            current = q.poll();
            x = current[1];
            y = current[0];
            for (int i=0;i<4;i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[ny][nx] && m[ny][nx] == 0) {
                    q.offer(new int[] { ny, nx });
                    visited[ny][nx] = true;
                    d[ny][nx] = d[y][x] + 1;

                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (answer < d[i][j]) answer = d[i][j];
                if (d[i][j]==0 && m[i][j]==0) {
                    answer = -1;
                    break;
                }
            }
            if (answer==-1) break;
        }
        System.out.println(answer);
    }
}
