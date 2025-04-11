import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int answer = 0;
        int cum = 0;
        for (int a: arr) {
            cum += a;
            answer += cum;
        }
        System.out.println(answer);
    }
}
