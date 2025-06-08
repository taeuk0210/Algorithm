import java.util.*;

public class Main {
    static char[][] map;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new char[n][n];
        for (char[] m: map) {
            Arrays.fill(m, ' ');
        }
        rec(n, 0, 0);
        
        StringBuilder sb = new StringBuilder();
        for (char[] m: map) {
            for (char c: m) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        
    }
    
    private static void rec(int len, int i, int j) {
        if (len == 1) {
            map[i][j] = '*';
            return;
        }
        int next = len / 3;
        int[] d = new int[] {0, next, 2*next};
        for (int di: d) {
            for (int dj: d) {
                if (di == next && dj == next) continue;
                rec(next, i+di, j+dj);
            }
        }
    }
}