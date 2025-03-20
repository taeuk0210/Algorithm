import java.util.*;

public class Main {
    static int N;
    static int M;
    static boolean[][] visited;
    static List<Integer> answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int K = sc.nextInt();

        visited = new boolean[N][M];
        for (int k = 0; k < K; k++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for (int i = y1; i <y2; i++) {
                for (int j = x1; j < x2; j++) {
                    visited[i][j] = true;
                }
            }
        }

        answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    bfs(i,j);
                }
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        for (int ans : answer) {
            System.out.print(ans+" ");
        }
    }
    public static void bfs(int i, int j) {
        int[] current, dy={-1,0,1,0}, dx={0,1,0,-1};
        int y,x,ny,nx;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            current = queue.poll();
            y = current[0];
            x = current[1];
            for (int k = 0; k < 4; k++) {
                nx = x + dx[k];
                ny = y + dy[k];
                if (0<=ny && ny<N && 0<=nx && nx<M && !visited[ny][nx]) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    count++;
                }
            }
        }
        answer.add(count);
    }
}
