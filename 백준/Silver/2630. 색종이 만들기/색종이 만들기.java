import java.util.*;

public class Main {
    static int blue = 0;
    static int white = 0;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        rec(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }
    
    private static void rec(int y, int x, int len) {
        int s = 0;
        for (int i=y; i<y+len; i++) {
            for (int j=x; j<x+len; j++) {
                s += arr[i][j];
            }
        }
        if (s == len * len) {
            blue++;
            return;
        }    
        if (s == 0) {
            white++;
            return;
        }
        if (len > 1) {
            len /= 2;
            rec(y, x, len);
            rec(y+len, x, len);
            rec(y, x+len, len);
            rec(y+len, x+len, len);
        }
    }
}