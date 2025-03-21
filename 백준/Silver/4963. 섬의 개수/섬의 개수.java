import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            M = sc.nextInt();
            N = sc.nextInt();
            if (N == 0 && M == 0) {
                break;
            }
            map = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                    }
                }
            }
            System.out.println(answer);
        }
    }
    public static void bfs(int i, int j) {
        int[] current, dy={-1,0,1,0,1,1,-1,-1}, dx={0,-1,0,1,-1,1,-1,1};
        int y, x, ny, nx;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            current = queue.poll();
            y = current[0];
            x = current[1];
            for (int k = 0; k < 8; k++) {
                ny = y + dy[k];
                nx = x + dx[k];
                if (0<=ny && ny<N && 0<=nx && nx<M && !visited[ny][nx] && map[ny][nx] == 1) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
        answer++;
    }
}
