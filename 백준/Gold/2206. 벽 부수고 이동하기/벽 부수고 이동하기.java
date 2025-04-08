import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] map = new int[N][M];
        boolean[][][] visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(sc.nextLine().split(""))
                    .mapToInt(Integer::parseInt).toArray();
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 1});
        visited[0][0][0] = true;

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, -1 ,0, 1};
        int answer = -1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int skip = cur[2];
            int dist = cur[3];
            if (y==N-1 && x==M-1) {
                answer = dist;
                break;
            }
            for (int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (0<=ny && ny<N && 0<=nx && nx<M) {
                    if (map[ny][nx] == 0 && !visited[ny][nx][skip]) {
                        queue.add(new int[]{ny, nx, skip, dist+1});
                        visited[ny][nx][skip] = true;
                    } else if (map[ny][nx] == 1 && skip == 0 && !visited[ny][nx][1]) {
                        queue.add(new int[]{ny, nx, 1, dist+1});
                        visited[ny][nx][1] = true;
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
