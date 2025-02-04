import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        for (int i=1; i<N; i++) 
            for (int j=0; j<3; j++) {{
                int m = 1000001;
                for (int k=0; k<3; k++) {
                    if (j!=k && arr[i-1][k] < m) m = arr[i-1][k];
                }
                arr[i][j] += m;
            }
        }
        System.out.print(Arrays.stream(arr[N-1]).min().getAsInt());
    }
}
