import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static int[] current;
    static int shark = 2;
    static int predation = 0;
    static int answer = 0;
    static boolean isContinue = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    current = new int[]{i, j,0};
                    map[i][j] = 0;
                }
            }
        }
        while (isContinue) {
            solve();
        }
        System.out.println(answer);
    }

    public static void solve() {
        boolean[][] visited = new boolean[N][N];
        int[] cur, dx = {-1,0,1,0}, dy = {0,1,0,-1};
        int y, x, ny, nx, time, dist = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b) -> a[2] != b[2] ? a[2] - b[2] :
                a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );
        pq.offer(new int[] {current[0], current[1], 0});
        visited[current[0]][current[1]] = true;
        while (!pq.isEmpty()) {
            cur = pq.poll();
            y = cur[0];
            x = cur[1];
            time = cur[2];
            dist = Math.max(time, dist);
            if (map[y][x] != 0 && map[y][x] < shark) {
                current = new int[] {y, x};
                answer += time;
                map[y][x] = 0;
                predation++;
                if (predation == shark) {
                    shark++;
                    predation = 0;
                }
                return;
            }

            for (int i = 0; i < 4; i++) {
                ny = y + dy[i];
                nx = x + dx[i];
                if (0<=ny && ny<N && 0<=nx && nx<N) {
                    if (map[ny][nx] <= shark && !visited[ny][nx]) {
                        pq.offer(new int[] {ny, nx, time + 1});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        isContinue = false;
    }
}
