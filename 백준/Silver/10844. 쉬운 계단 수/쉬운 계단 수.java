import java.util.*;

public class Main {
        /*
        0:     | 1,
        1: 2,  | 0,2
        2: 1,3 | 1,3
        3: 2,4 | 2,4
        ...
        8: 7,9 | 7,9
        9: 8,  | 8,
        */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[101][10];
        for (int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }
        for (int i=2; i<=n; i++) {
            for (int d=0; d<=9; d++) {
                if (d > 0) dp[i][d] = (dp[i][d] + dp[i-1][d-1]) % 1_000_000_000;
                if (d < 9) dp[i][d] = (dp[i][d] + dp[i-1][d+1]) % 1_000_000_000;
            }
        }
        int answer = 0;
        for (int i=0; i<=9; i++) {
            answer = (answer + dp[n][i]) % 1000000000;
        }
        System.out.println(answer);
    }
}