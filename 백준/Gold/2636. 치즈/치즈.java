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
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Queue<int[]> queue;
        boolean[][] visited = new boolean[N][M];
        int time=0, prevCount=0, count;
        int[] current;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int y,x,ny,nx;
        while (true) {
            count = scanBoard(board);
            if (count == 0) break;
            prevCount = count;

            queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            visited = new boolean[N][M];
            visited[0][0] = true;
            while (!queue.isEmpty()) {
                current = queue.poll();
                y = current[0];
                x = current[1];
                for (int i = 0; i < 4; i++) {
                    ny = y + dy[i];
                    nx = x + dx[i];
                    if (0<=ny && ny<N && 0<=nx && nx<M) {
                        if (board[ny][nx] == 0 && !visited[ny][nx]) {
                            queue.add(new int[]{ny, nx});
                            visited[ny][nx] = true;
                        } else if (board[ny][nx] == 1 && !visited[ny][nx]) {
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j]) board[i][j] = 0;
                }
            }
            time++;
        }
        System.out.println(time);
        System.out.println(prevCount);
    }
    public static int scanBoard(int[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
