
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 666;
        while (n > 0) {
            if (String.valueOf(m).contains("666")) n--;
            m++;
        }
        System.out.println(--m);
    }
}
