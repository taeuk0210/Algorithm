import java.util.*;

public class Main {
    static int N;
    static int M;
    static char[][] map;
    static boolean[][] visited;
    static int normal;
    static int colorblind;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        List<char[]> input = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            input.add(sc.nextLine().toCharArray());
        }
        map = input.toArray(new char[input.size()][]);
        M = map[0].length;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    normal(i, j);
                }
            }
        }
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    colorblind(i, j);
                }
            }
        }
        System.out.println(normal + " " + colorblind);
    }
    public static void normal(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (0<=ny && ny<N && 0<=nx && nx<M) {
                    if (!visited[ny][nx] && map[y][x] == map[ny][nx]) {
                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        normal++;
    }
    public static void colorblind(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (0<=ny && ny<N && 0<=nx && nx<M) {
                    if (!visited[ny][nx] && check(map[y][x],map[ny][nx])) {
                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        colorblind++;
    }

    public static boolean check(char prev, char next) {
        boolean answer;
        switch (prev) {
            case 'R':
            case 'G':
                answer = next != 'B';
                break;
            default:
                answer = next == 'B';
        }
        return answer;
    }
}
