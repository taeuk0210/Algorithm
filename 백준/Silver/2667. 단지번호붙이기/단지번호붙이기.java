import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        visited = new boolean[N][N];
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == '1') {
                    answer.add(bfs(i, j));
                }
            }
        }
        System.out.println(answer.size());
        answer.stream().sorted().forEach(System.out::println);
    }

    public static int bfs(int i, int j) {
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.add(new int[]{i, j});
        int[] current, dy = {-1,0,1,0}, dx={0,-1,0,1};
        int y,x,ny,nx;
        while (!queue.isEmpty()) {
            current = queue.poll();
            y = current[0];
            x = current[1];
            for (int k = 0; k < 4; k++) {
                ny = y + dy[k];
                nx = x + dx[k];
                if (0<=ny && ny<N && 0<=nx && nx<N && !visited[ny][nx] && map[ny][nx] == '1') {
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                    count++;
                }
            }
        }
        return count;
    }
}
