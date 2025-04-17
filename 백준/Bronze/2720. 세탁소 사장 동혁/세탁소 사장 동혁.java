import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            int m = sc.nextInt();
            for (int d: new int[] {25, 10, 5, 1}) {
                System.out.print(m/d + " ");
                m %= d;
            }
            System.out.println();
        }
    }
}