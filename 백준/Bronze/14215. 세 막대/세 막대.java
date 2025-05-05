import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = 0;
        int sum = 0;
        for (int i=0; i<3; i++) {
            int n = sc.nextInt();
            m = Math.max(m, n);
            sum += n;
        }
        sum -= m;
        if (sum <= m) {
            m = sum - 1;
        }
        System.out.println(sum + m);
    }
}