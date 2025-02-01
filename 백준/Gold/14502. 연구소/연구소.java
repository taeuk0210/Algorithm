
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<String> result = new ArrayList<>();
    static List<int[]> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] board = new int[N][M];
        int count, maxCount=0, zeroCount=0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    list.add(i*M + j);
                    zeroCount++;
                } else if (board[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        for (int[] wall : combination(list, 3)) {
            count = bfs(board, wall, zeroCount, N, M);
            if (count > maxCount) {
                maxCount = count;
            }
        }
        System.out.println(maxCount);

    }
    public static int bfs(int[][] board, int[] wall, int count, int N, int M) {
        int[] current;
        int y, x, ny, nx;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = board[i][j];
            }
        }
        Queue<int[]> q = new LinkedList<>();
        queue.stream().forEach(q::add);

        for (int w : wall) {
            map[w/M][w%M] = 1;
            count--;
        }
        while (!q.isEmpty()) {
            current = q.poll();
            y = current[0];
            x = current[1];
            for (int i=0; i<4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (0<=ny && ny<N && 0<=nx && nx<M && map[ny][nx]==0) {
                    q.add(new int[] {ny, nx});
                    map[ny][nx] = 2;
                    count--;
                }
            }
        }
        return count;
    }

    public static List<int[]> combination(List<Integer> n, int r) {
        result.clear();
        rec(n, r, 0, "");
        return result.stream()
                .map(s -> Arrays.stream(s.split(" "))
                        .mapToInt(Integer::parseInt).toArray())
                .collect(Collectors.toList());
    }
    public static void rec(List<Integer> n, int r, int start, String current) {
        if (current.strip().split(" ").length == r) {
            result.add(current.strip());
            return;
        }
        for (int i = start; i < n.size(); i++) {
            rec(n, r, i + 1, current + " " + n.get(i));
        }
    }
}
