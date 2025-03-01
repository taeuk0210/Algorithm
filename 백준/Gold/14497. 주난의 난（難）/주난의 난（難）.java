import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        input = sc.nextLine().split(" ");
        int[] start = new int[2], end = new int[2];
        start[0] = Integer.parseInt(input[0]) - 1;
        start[1] = Integer.parseInt(input[1]) - 1;
        end[0] = Integer.parseInt(input[2]) - 1;
        end[1] = Integer.parseInt(input[3]) - 1;

        char[][] map = new char[n][m];
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        int[] current, dx = {-1,0,1,0}, dy = {0,-1,0,1};
        int y, x, ny, nx, cost;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        queue.offer(new int[]{ start[0], start[1], 1});
        distance[start[0]][start[1]] = 1;
        while (!queue.isEmpty()) {
            current = queue.poll();
            y = current[0];
            x = current[1];
            cost = current[2];
            if (map[y][x] == '#') {
                break;
            }
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (0<=ny && ny<n && 0<=nx && nx<m && distance[ny][nx]==0) {
                    distance[ny][nx] = map[ny][nx] == '0' ? cost : cost + 1;
                    queue.offer(new int[]{ny,nx,distance[ny][nx]});
                }
            }
        }
        System.out.println(distance[end[0]][end[1]] - 1);

    }
}
