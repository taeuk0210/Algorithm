import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int[] dp = new int[k+1];
        for (int i = 1; i <= k; i++) {
            int a = 100001;
            for (int c : coins) {
                if (i == c) {
                    a = 1;
                    break;
                } else if (c>=0 && i-c>=0){
                    a = Math.min(a, dp[c] + dp[i - c]);
                }
            }
            dp[i] = a;
        }
        //System.out.println(Arrays.toString(dp));
        System.out.println(dp[k]==100001 ? -1 : dp[k]);

    }
}
