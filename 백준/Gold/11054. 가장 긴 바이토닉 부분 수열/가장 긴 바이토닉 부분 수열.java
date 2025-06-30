import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dpFromLeft = new int[n+1];
        int[] dpFromRight = new int[n+1];
        
        int[] arr = new int[n+1];
        int[] rev = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = sc.nextInt();
            rev[n+1-i] = arr[i];
        }
        
        getSubSeq(arr, dpFromLeft);
        getSubSeq(rev, dpFromRight);
        
        //System.out.println(Arrays.toString(dpFromLeft));
        //System.out.println(Arrays.toString(dpFromRight));
        
        int answer = 0;
        for (int i=1; i<=n; i++) {
            answer = Math.max(answer, dpFromLeft[i] + dpFromRight[n+1-i]);
        }
        System.out.println(answer-1);
        
    }
    private static void getSubSeq(int[] arr, int[] dpFrom) {
        int[] dp = new int[arr.length];
        dp[1] = arr[1];
        int s = 2;
        dpFrom[1] = 1;
        for (int i=2; i<=arr.length-1; i++) {
            for (int j=1; j<=s; j++) {
                if (dp[j] == 0 && arr[i] > dp[j-1]) {
                    dp[j] = arr[i];
                    dpFrom[i] = j;
                    s++;
                    break;
                } else if (dp[j] >= arr[i] && arr[i] > dp[j-1]) {
                    dp[j] = arr[i];
                    dpFrom[i] = j;
                    break;
                }
            }
        }
    }
}