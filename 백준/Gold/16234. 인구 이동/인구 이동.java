import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();

        int[][][] map = new int[N][N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j][0] = sc.nextInt();
                map[i][j][1] = N * i + j;
            }
        }
        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1}, current;
        int y, x, ny, nx, answer=0;
        while (true) {
            boolean[][] visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;

                    Queue<int[]> bfsQueue = new LinkedList<>();
                    List<int[]> union = new ArrayList<>();
                    bfsQueue.offer(new int[] {i, j});
                    visited[i][j] = true;
                    int sum = 0, count = 0;

                    while (!bfsQueue.isEmpty()) {
                        current = bfsQueue.poll();
                        y = current[0];
                        x = current[1];
                        union.add(new int[]{y, x});
                        sum += map[y][x][0];
                        count++;

                        for (int k = 0; k < 4; k++) {
                            ny = y + dy[k];
                            nx = x + dx[k];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx]) {
                                int diff = Math.abs(map[y][x][0] - map[ny][nx][0]);
                                if (L <= diff && diff <= R) {
                                    bfsQueue.offer(new int[]{ny, nx});
                                    visited[ny][nx] = true;
                                    moved = true;
                                }
                            }
                        }
                    }
                    int avg = sum / count;
                    for (int[] pos : union) {
                        map[pos[0]][pos[1]][0] = avg;
                    }
                }
            }
            if (!moved) break;
            answer++;
        }
        System.out.print(answer);
    }
}
