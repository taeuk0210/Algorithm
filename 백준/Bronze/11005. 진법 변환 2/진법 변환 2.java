import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        String answer = "";

        while (n > 0) {
            int r = n % b;
            answer = r >= 10 ? (char)(r+55) + answer : r + answer;
            n /= b;
        }
        System.out.println(answer);
    }
}
