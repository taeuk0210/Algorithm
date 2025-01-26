import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] nb = sc.nextLine().split(" ");
        int n = Integer.parseInt(nb[0]);
        long b = Long.parseLong(nb[1]);
        int[][] answer = new int[n][n];
        for (int i=0; i<n; i++) {
            answer[i][i] = 1;
        }

        int[][] A = new int[n][n];
        for (int i=0; i<n; i++) {
            String[] row = sc.nextLine().split(" ");
            for (int j=0; j<n; j++) {
                A[i][j] = Integer.parseInt(row[j]);
            }
        }
        String bin = getBin(b);
        for (int i=0; i<bin.length(); i++) {
            if (i>=1) {
                A = matmul(A, A, n);
            }
            if (bin.charAt(i)=='1') {
                answer = matmul(answer, A, n);
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(answer[i][j]+(j==n-1 ? "\n" : " "));
            }
        }

    }
    public static String getBin(long n) {
        String bin = "";
        while (n > 0) {
            bin += n%2;
            n /= 2;
        }
        return bin;
    }

    public static int[][] matmul(int[][] A, int[][] B, int n) {
        int[][] C = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
                C[i][j] %= 1000;
            }
        }
        return C;
    }

}