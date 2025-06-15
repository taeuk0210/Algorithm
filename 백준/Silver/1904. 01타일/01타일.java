import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 2) {
            System.out.println(n);
            return;
        }
        /*
        1 = 1
        2 = 2
        3 = 111 100 001 -> 3
        4 = 5
        5 = 11111 11100 11001 10011 00111 10000 00100 00001
        */
        int f1 = 1;
        int f2 = 2;
        for (int i=3; i<=n; i++) {
            int t = f2;
            f2 += f1;
            f2 %= 15746;
            f1 = t;
        }
        System.out.println(f2);
        
    }
}