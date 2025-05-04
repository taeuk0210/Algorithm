import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 1) {
            System.out.println(n);
            return;
        }
        long f0 = 0L;
        long f1 = 1L;
        for (int i=0; i<n-1; i++) {
            long t = f1;
            f1 = f1 + f0;
            f0 = t;
        }
        System.out.println(f1);
    }
}