import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[t];
        int max = 0;
        for (int i=0; i<t; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        
        boolean[] isPrime = isPrimes(max);
        
        for (int i=0; i<t; i++) {
            int n = arr[i];
            int count = 0;
            for (int p=2; p<=(int) (n / 2); p++) {
                if (isPrime[p] && isPrime[n-p]) count++;
            }
            System.out.println(count);
        }
    }
    private static boolean[] isPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i<=n; i++) {
            for (int j = 1; i * j <= n; j++) {
                if (j == 1) continue;
                isPrime[i*j] = false;
            }
        }
        return isPrime;
    }
}