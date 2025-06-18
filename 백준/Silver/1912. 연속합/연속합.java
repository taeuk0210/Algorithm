import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = arr[0];
        int sum = arr[0];
        for (int i=1; i<n; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            answer = Math.max(sum, answer);
        }
        System.out.println(answer);
    }
}