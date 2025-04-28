import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 1;
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a==0 && b==0 && c==0) {
                return;
            }
            System.out.println("Case " + count++ + ": " + ((c / b) * a + Math.min(a, c % b)));
        }
    }
}