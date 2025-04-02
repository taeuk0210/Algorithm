import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i=0; i<N; i++) {
            System.out.println(lcm(sc.nextInt(), sc.nextInt()));
        }
    }
    
    public static int lcm(int a, int b) {
        int answer = a*b;
        int t;
        while (b > 0) {
            t = a%b;
            a = b;
            b = t;
        }
        return answer / a;
    }
}