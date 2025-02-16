import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        char[][] map = new char[N][M];
        int[][] escape = new int[N][M];
        int[][] fire = new int[N][M];
        boolean[][] fVisited = new boolean[N][M];
        boolean[][] eVisited = new boolean[N][M];

        Queue<int[]> eQueue = new LinkedList<>();
        Queue<int[]> fQueue = new LinkedList<>();
        List<int[]> exits = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            map[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'F') {
                    fQueue.offer(new int[]{i, j});
                    fire[i][j] = 1;
                    fVisited[i][j] = true;
                }
                if (map[i][j] == 'J') {
                    eQueue.offer(new int[]{i, j});
                    escape[i][j] = 1;
                    eVisited[i][j] = true;
                }
                if ((map[i][j]=='.' || map[i][j]=='J') &&
                        (i==0 || j==0 || i==N-1 || j==M-1)) {
                    exits.add(new int[]{i, j});
                }
            }
        }

        int[] current, dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
        int y, x, ny, nx;
        while (!fQueue.isEmpty()) {
            current = fQueue.poll();
            y = current[0];
            x = current[1];
            for (int i = 0; i < 4; i++) {
                ny = y + dy[i];
                nx = x + dx[i];
                if (0 <= ny && ny < N && 0 <= nx && nx < M && !fVisited[ny][nx] && map[ny][nx] != '#') {
                    fQueue.offer(new int[]{ny, nx});
                    fVisited[ny][nx] = true;
                    fire[ny][nx] = fire[y][x] + 1;
                }
            }
        }
        while (!eQueue.isEmpty()) {
            current = eQueue.poll();
            y = current[0];
            x = current[1];
            for (int i = 0; i < 4; i++) {
                ny = y + dy[i];
                nx = x + dx[i];
                if (0 <= ny && ny < N && 0 <= nx && nx < M && !eVisited[ny][nx] && map[ny][nx] != '#' && map[ny][nx] != 'F') {
                    if (fire[ny][nx] > escape[y][x]+1 || fire[ny][nx]==0) {
                        escape[ny][nx] = escape[y][x] + 1;
                        eQueue.offer(new int[]{ny, nx});
                        eVisited[ny][nx] = true;
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int[] pos : exits) {
          if (escape[pos[0]][pos[1]] > 0) {
            answer = Math.min(answer, escape[pos[0]][pos[1]]);
          }
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer);
        }
    }
}