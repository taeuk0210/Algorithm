import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        for (int i=0; i<n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        Arrays.sort(a, (b,c) -> c[1] != b[1] ? b[1]-c[1] : b[0]-c[0]);
        for (int[] b: a) {
            System.out.println(b[0] + " " + b[1]);
        }
    }
}