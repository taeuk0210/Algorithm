import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[3];
        int[] d = {300, 60, 10};
        for (int i=0; i<3; i++) {
            a[i] = n / d[i];
            n %= d[i];
        }
        if (n > 0) {
            System.out.println(-1);
        } else {
            for (int ans: a) {
                System.out.print(ans+" ");
            }
        }
    }

}