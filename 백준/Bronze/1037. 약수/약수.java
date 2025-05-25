import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        long[] arr = new long[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextLong();
        }
        if (n == 1) {
            System.out.println(arr[0] * arr[0]);
            return;
        }
        long min = Arrays.stream(arr).min().getAsLong();
        long max = Arrays.stream(arr).max().getAsLong();
        System.out.println(min * max);
        
    }
}