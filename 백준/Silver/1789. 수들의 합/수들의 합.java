import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long answer = 0;
        long i=1;
        while (n >= i) {
            n -= i;
            answer++;
            i++;
        }
        System.out.println(answer);
    }
}
