import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        int max = 10;
        for (int i=0; i<n; i++) {
            p[i] = sc.nextInt();
            max = Math.max(max, p[i]);
        }
        long[] dp = new long[max+1];
        for (int i=1; i<=max; i++) {
            if (i <= 5) 
                dp[i] = i <= 3 ? 1 : 2;
            else
                dp[i] = dp[i-1] + dp[i-5];
        }
        
        for (int i=0; i<n; i++) {
            System.out.println(dp[p[i]]);
        }
        
    }
}