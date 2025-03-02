import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int answer = 1;
        for (int i=0; i<k; i++) {
            answer *= (n-i);
        }
        for (int i=1; i<=k; i++) {
            answer /= i;
        }
        System.out.println(answer);
    }
}