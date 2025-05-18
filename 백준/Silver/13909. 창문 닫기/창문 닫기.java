import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long answer = 0;
        for (long i=1; i*i<=n; i++) {
            answer++;
        }
        System.out.println(answer);
    }

}