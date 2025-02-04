import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[][] t = new int[N][N];
        for (int i = 0; i < N; i++) {
            t[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        /*
        * 0
        * 0 1
        * 0 1 2
        * 0 1 2 3
        * */
        for (int i=1; i<N; i++) {
            for (int j=0; j<=i; j++) {
                if (j==0) t[i][j] += t[i-1][j];
                else if (j==i) t[i][j] += t[i-1][j-1];
                else t[i][j] += Math.max(t[i-1][j-1], t[i-1][j]);
            }
        }
        System.out.print(Arrays.stream(t[N-1]).max().getAsInt());
    }
}
