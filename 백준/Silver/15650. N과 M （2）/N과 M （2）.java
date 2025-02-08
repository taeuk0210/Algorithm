import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        rec(n, m, 0, new boolean[n+1], new int[m]);

    }

    public static void rec(int n, int m, int index, boolean[] visited, int[] input) {
        if (index == m) {
            for (int i: input) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        int start = index == 0 ? 0 : input[index-1];
        for (int i=start+1; i<=n; i++) {
            if (i<=n && !visited[i]) {
                visited[i] = true;
                input[index] = i;
                rec(n, m, index+1, visited, input);
                visited[i] = false;
                input[index] = 0;
            }
        }
    }
}
