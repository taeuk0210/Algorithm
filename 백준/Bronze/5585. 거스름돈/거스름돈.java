import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1000 - sc.nextInt();
        int answer = 0;
        for (int d: new int[] {500, 100, 50, 10, 5, 1}) {
            answer += n / d;
            n %= d;
        }
        System.out.println(answer);
    }
}