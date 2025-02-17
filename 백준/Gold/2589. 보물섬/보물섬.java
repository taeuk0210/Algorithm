import java.util.*;

public class Main {
    static List<int[]> land;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    answer = Math.max(answer, bfs(map, new int[]{i, j}));
                }
            }
        }
        System.out.println(answer-1);
    }

    public static int bfs(char[][] map, int[] start) {
        int[] current, dx={-1,0,1,0}, dy={0,-1,0,1};
        int y,x,ny,nx, answer=0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        int[][] distance = new int[map.length][map[0].length];
        q.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        distance[start[0]][start[1]] = 1;
        while (!q.isEmpty()) {
            current = q.poll();
            y = current[0];
            x = current[1];
            for (int k = 0; k < 4; k++) {
                ny = y + dy[k];
                nx = x + dx[k];
                if (0<=ny&&ny<map.length&&0<=nx&&nx<map[0].length && map[ny][nx]=='L' && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny,nx});
                    distance[ny][nx] = distance[y][x] + 1;
                    answer = Math.max(answer, distance[ny][nx]);
                }
            }
        }
        return answer;
    }
}
