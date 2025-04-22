import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);      
        int N = sc.nextInt();
        int M = sc.nextInt();        
        int d = N % 6;
        int minSet = 1001;
        int minOne = 1001;
        for (int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            minSet = Math.min(minSet, a);
            minOne = Math.min(minOne, b);
        }
        
        System.out.println(Math.min(((N + 5) / 6) * minSet,
                                    Math.min((N / 6) * minSet + (N % 6) * minOne,
                                             N * minOne)));
    }
}