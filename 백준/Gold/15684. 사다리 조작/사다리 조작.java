import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int H;
    static int[][] map;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        map = new int[H+1][N+1];
        for (int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
        }
        answer = 10;
        rec(0);
        System.out.println(answer == 10 ? -1 : answer);
    }

    public static void rec(int depth) {
        if (check()) {
            answer = Math.min(answer, depth);
        }
        if (depth == 3) {
            return;
        }
        for (int i=1; i<=H; i++) {
            for (int j=1; j<N; j++) {
                if ((map[i][j] == 1) ||
                    (map[i][j-1] == 1) ||
                    (map[i][j+1] == 1)) {
                    continue;
                }
                map[i][j] = 1;
                rec(depth+1);
                map[i][j] = 0;
            }
        }
    }

    public static boolean check() {
        for (int i=1; i<=N; i++) {
            if (i != down(i)) {
                return false;
            }
        }
        return true;
    }

    public static int down(int start) {
        for (int h=0; h<H; h++) {
            if (map[h+1][start] == 1) {
                start++;
            } else if (start-1 >= 1 && map[h+1][start-1]==1) {
                start--;
            }
        }
        return start;
    }
}
