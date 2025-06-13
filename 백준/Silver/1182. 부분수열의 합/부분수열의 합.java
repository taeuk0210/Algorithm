import java.util.*;

public class Main {
    static int n;
    static int s;
    static int[] arr;
    static int answer = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        for (int k = 1; k<=n; k++) {
            rec(0, 0, new int[k]);
        }
        System.out.println(answer);
        
    }
    
    public static void rec(int depth, int start, int[] current) {
        if (depth == current.length) {
            int sum = 0;
            for (int i=0; i<depth; i++) {
                sum += arr[current[i]];
            }
            if (sum == s) {
                answer++;
            }
            return;
        }
        
        for (int i=start; i<n; i++) {
            current[depth] = i;
            rec(depth+1, i+1, current);
            current[depth] = 0;
        }
    }
}