import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (i >= 1) {
                    arr[i][j] += arr[i - 1][j];
                }
                if (j >= 1) {
                    arr[i][j] += arr[i][j - 1];
                }
                if (i >= 1 && j >= 1) {
                    arr[i][j] -= arr[i-1][j-1];
                }
            }
        }
//        for (int[] a: arr) {
//            System.out.println(Arrays.toString(a));
//        }

        for (int i=0; i<m; i++) {
            int x1 = sc.nextInt() - 1;
            int y1 = sc.nextInt() - 1;
            int x2 = sc.nextInt() - 1;
            int y2 = sc.nextInt() - 1;
            int answer = arr[x2][y2];
            if (x1 >= 1) {
                answer -= arr[x1-1][y2];
            }
            if (y1 >= 1) {
                answer -= arr[x2][y1-1];
            }
            if (x1 >= 1 && y1 >= 1) {
                answer += arr[x1-1][y1-1];
            }
            System.out.println(answer);
        }
    }
}
