import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] dp = new int[n + 1][3];
        dp[1][0] = arr[1];
        dp[1][1] = 0;
        for (int i = 2; i <= n; i++) {
            if (dp[i-1][2] == 1) {
                dp[i][0] = dp[i-1][1] + arr[i];
                dp[i][2] = 1;
            } else {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + arr[i];
                dp[i][2] = 1;
            }
            dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + arr[i];
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}
