import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] answer = new int[N-S+1];
        for (int i=0; i<S; i++) {
            answer[0] += arr[i];
        }
        
        int s = 0, e = S, max = answer[0];
        
        for (int i=1; i<N-S+1; i++) {
            answer[i] = answer[i-1];
            answer[i] -= arr[s++];
            answer[i] += arr[e++];

            max = Math.max(max, answer[i]);
        }
        System.out.print(max);
    }
}
