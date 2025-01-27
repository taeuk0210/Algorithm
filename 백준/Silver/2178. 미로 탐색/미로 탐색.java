import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(sc.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        boolean[][] visited = new boolean[n][m];

        int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0, -1, 0, 1};
        int x,y,nx,ny,d=0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            y = current[0];
            x = current[1];
            d = current[2];

            if (y==n-1 && x==m-1) break;

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (0<=ny && ny<n && 0<=nx && nx<m && arr[ny][nx]==1 && !visited[ny][nx]) {
                    queue.add(new int[] {ny, nx, d+1});
                    visited[ny][nx] = true;
                }
            }
        }
        System.out.print(d);

    }
}
