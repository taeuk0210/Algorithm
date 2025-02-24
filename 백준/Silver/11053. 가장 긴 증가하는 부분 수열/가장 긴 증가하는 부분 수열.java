import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            for (int j = 0; j < i; j++) {
                if (arr[j][0] < arr[i][0]) {
                    arr[i][1] = Math.max(arr[j][1], arr[i][1]);
                }
            }
            arr[i][1]++;
        }
//        for (int[] a : arr) {
//            System.out.println(Arrays.toString(a));
//        }
        System.out.print(Arrays.stream(arr)
                .max(Comparator.comparingInt(a -> a[1]))
                .get()[1]);
    }
}
