import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int H = sc.nextInt();
        int[][][] tmt = new int[H][N][M];

        Queue<int[]> queue = new LinkedList<>();
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    tmt[h][n][m] = sc.nextInt();
                    if (tmt[h][n][m] == 1) {
                        queue.add(new int[] { h, n, m });
                    }
                }
            }
        }

        int[] dh = { 0, 0, 0, 0, 1, -1 };
        int[] dx = { -1, 0, 1, 0, 0, 0 };
        int[] dy = { 0, 1, 0, -1, 0, 0 };
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int h = now[0];
            int x = now[1];
            int y = now[2];

            for (int i = 0; i < 6; i++) {
                int nh = h + dh[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nh && nh < H && 0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (tmt[nh][nx][ny] == 0) {
                        tmt[nh][nx][ny] = tmt[h][x][y] + 1;
                        queue.add(new int[] { nh, nx, ny });
                    }
                }
            }
        }

        int max = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tmt[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, tmt[h][n][m]);
                }
            }
        }
        System.out.println(max - 1);
    }
}
