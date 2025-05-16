import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] d = new long[n-1];
        long prev = sc.nextLong();
        long s = 0;
        for (int i=0; i<n-1; i++) {
            long current = sc.nextLong();
            d[i] = current - prev;
            prev = current;
            s += d[i];
        }
        
        long gcd = Arrays.stream(d).reduce(0, (a, b)->{
            while (b > 0) {
               long t = a;
               a = b;
               b = t % b;
            }
            return a;
        });
        System.out.println((long)(s/gcd - n + 1));
        
    }
}