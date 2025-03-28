import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int count = 0, max = 0, answer=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || arr[i][j] == 0) {
                    continue;
                }
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                visited[i][j] = true;
                count = 1;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int y = cur[0];
                    int x = cur[1];
                    for (int k = 0; k < 4; k++) {
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        if (0<=ny && ny<n && 0<=nx && nx<m && !visited[ny][nx] && arr[ny][nx] == 1) {
                            q.offer(new int[]{ny, nx});
                            visited[ny][nx] = true;
                            count++;
                        }
                    }
                }
                max = Math.max(max, count);
                answer++;
            }
        }
        System.out.println(answer);
        System.out.println(max);
    }
}
