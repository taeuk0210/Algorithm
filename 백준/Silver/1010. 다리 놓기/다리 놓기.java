import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i=0; i<t; i++) {
            String[] str = sc.nextLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            solve(m, n);
        }
    }
    private static void solve(int n, int r) {
        long answer = 1;
        for (long i=1; i<=r; i++) {
            answer = answer * n-- / i;
        }
        System.out.println(answer);
    }
}