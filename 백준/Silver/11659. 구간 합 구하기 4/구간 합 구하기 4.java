import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = i==0 ? sc.nextInt() : arr[i-1] + sc.nextInt();
        }
        for (int i=0; i<m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int answer = arr[b];
            if (a-1>=0) {
                answer -= arr[a-1];
            }
            System.out.println(answer);
        }
    }
}