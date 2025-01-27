import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            A[i] = Arrays.stream(sc.nextLine().split(" " ))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int[][] M = A.clone();

        for (int i=0; i<n; i++) {
            M = matmul(M, A, n);
        }

        for (int[] row : M) {
            System.out.println(Arrays.stream(row).mapToObj(String::valueOf).reduce((a,b)->a+" "+b).get());
        }
    }

    public static int[][] matmul(int[][] M, int[][] A, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        if (A[i][k] * M[k][j] == 1) {
                            M[i][j] = 1;
                            break;
                        }
                    }
                }

            }
        }
        return M;
    }
}
