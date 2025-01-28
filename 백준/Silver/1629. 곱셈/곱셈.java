

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] n = sc.nextLine().split(" ");
        long a = Long.parseLong(n[0]);
        long b = Long.parseLong(n[1]);
        long c = Long.parseLong(n[2]);
        long answer = 1;

        while (b > 0) {
            if (b%2 == 1) {
                answer = (answer * a) % c;
            }
            a = (a * a) % c;
            b /= 2;
        }
        System.out.print(answer);
    }
}
