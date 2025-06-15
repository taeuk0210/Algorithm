import java.util.*;

public class Main {
    static int f1 = 0;
    static int f2 = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f1(n);
        f2(n);
        System.out.println(f1 + " " + f2);
        
    }
    
    private static int f1(int n) {
        
        if (n <= 2) {f1++;return 1;}
        else return f1(n-1) + f1(n-2);
    }
    
    private static int f2(int n) {
        
        int a0 = 1, a1 = 1;
        for (int i=3; i<=n; i++) {
            f2++;
            int t = a1;
            a1 = a0 + a1;
            a0 = t;
        }
        return a1;
    }
}