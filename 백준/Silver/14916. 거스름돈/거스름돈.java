import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = 0;
        while (n >= 0) {
            if (n % 5 == 0) {
                answer += n / 5;
                System.out.println(answer);
                return;
            }
            n -= 2;
            answer++;
        }
        System.out.println(-1);
    }
}
