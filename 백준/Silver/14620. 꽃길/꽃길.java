import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int answer = 200*30;
    static int cost;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        rec(0);
        System.out.println(answer);
    }

    public static void rec(int n) {
        if (n==3) {
            answer = Math.min(answer, cost);
            return;
        }
        int[] dy = {-1,0,1,0,0}, dx={0,-1,0,1,0};
        for (int i=1; i<N-1; i++) {
            for (int j=1; j<N-1; j++) {
                boolean isAvailable = true;
                for (int k=0; k<5; k++) {
                    isAvailable &= !visited[i+dy[k]][j+dx[k]];
                }
                if (isAvailable) {
                    for (int k=0; k<5; k++) {
                        cost += map[i+dy[k]][j+dx[k]];
                        visited[i+dy[k]][j+dx[k]] = true;
                    }
                    rec(n+1);
                    for (int k=0; k<5; k++) {
                        cost -= map[i+dy[k]][j+dx[k]];
                        visited[i+dy[k]][j+dx[k]] = false;
                    }
                }
            }
        }
    }
}
