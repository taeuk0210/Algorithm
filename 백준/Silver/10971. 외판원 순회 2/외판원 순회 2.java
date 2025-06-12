import java.util.*;

public class Main {
    static int n;
    static int[] c;
    static int[][] w;
    static boolean[] v;
    static int answer = Integer.MAX_VALUE;
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        v = new boolean[n];
        c = new int[n];
        w = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                w[i][j] = sc.nextInt();
            }
        }
        rec(0);
        System.out.print(answer);
    }
    private static void rec(int depth) {
        if (depth == n) {
            int cost = 0;
            for (int i=1; i<n; i++) {
                cost += w[c[i-1]][c[i]];
            }
            if (w[c[n-1]][c[0]] != 0) {
                cost += w[c[n-1]][c[0]];
                answer = Math.min(answer, cost);
            }
            return;
        }
        for (int i=0; i<n; i++) {
            if (!v[i]) {
                if (depth == 0 || w[c[depth-1]][i] != 0) {
                    c[depth] = i;
                    v[i] = true;
                    rec(depth+1);
                    c[depth] = 0;
                    v[i] = false;
                }
            }
        }
        
    }
}