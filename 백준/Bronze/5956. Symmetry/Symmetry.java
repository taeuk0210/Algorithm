import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int count = 0;

        while (N%2==1 && M%2==1) {
            count++;
            N -= 1;
            N /= 2;
            M -= 1;
            M /= 2;
        }
        int answer = 0;
        for (int i=0; i<count; i++) {
            answer += Math.pow(4, i);
        }
        System.out.print(answer);
    }
}
