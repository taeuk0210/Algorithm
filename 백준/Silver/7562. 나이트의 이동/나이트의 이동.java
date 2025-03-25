import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i=0; i<N; i++) {
            int L = sc.nextInt();
            int y1 = sc.nextInt();
            int x1 = sc.nextInt();
            int y2 = sc.nextInt();
            int x2 = sc.nextInt();
            bfs(L, y1,x1,y2,x2);
        }
    }
    public static void bfs(int L, int y1, int x1, int y2, int x2) {
        int[] current, dy={2, 1, -1, -2, -2, -1, 1, 2}, dx={1, 2, 2, 1, -1, -2, -2, -1};
        int y, x, ny, nx, cost;
        boolean[][] visited = new boolean[L][L];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y1, x1, 0});
        visited[y1][x1] = true;

        while (!queue.isEmpty()) {
            current = queue.poll();
            y = current[0];
            x = current[1];
            cost = current[2];
            if (y==y2 && x==x2) {
                System.out.println(cost);
                return;
            }
            for (int k=0; k<8; k++) {
                ny = y + dy[k];
                nx = x + dx[k];
                if (0<=ny && ny<L && 0<=nx && nx<L && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx, cost + 1});
                }
            }
        }
    }
}
