import java.util.*;

public class Main  {
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i=0; i<T; i++) {
            solve(sc);
        }
    }
    public static void solve(Scanner sc) {
        String[] input = sc.nextLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            String[] line = sc.nextLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            map[y][x] = 1;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
    public static void bfs(int i, int j) {
        int[] current, dx = {-1,0,1,0}, dy={0,-1,0,1};
        int y,x,ny,nx;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i,j});
        visited[i][j] = true;
        while (!q.isEmpty()) {
            current = q.poll();
            y = current[0];
            x = current[1];
            for (int k=0; k<4; k++) {
                nx = x + dx[k];
                ny = y + dy[k];
                if (0<=ny && ny<N &&0<=nx && nx<M && !visited[ny][nx] && map[ny][nx]==1) {
                    visited[ny][nx] = true;
                    q.add(new int[] {ny,nx});
                }
            }
        }
    }
}
