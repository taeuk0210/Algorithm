import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

//        for (int[] a: arr) {
//            System.out.println(Arrays.toString(a));
//        }

        int answer = 1;
        int endTime = arr[0][1];
        for (int i = 1; i < N; i++) {
            if (arr[i][0] >= endTime) {
                endTime = arr[i][1];
                answer++;
            }}
        System.out.println(answer);
    }
}