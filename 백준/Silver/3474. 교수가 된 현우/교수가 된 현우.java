import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            System.out.println(divide5(sc.nextInt()));
        }
    }
    public static int divide5(int n) {
        int count = 0;
        int pow = 1;
        while (Math.pow(5, pow) <= n) {
            count += n / Math.pow(5, pow);
            pow++;
        }
        return count;
    }
}