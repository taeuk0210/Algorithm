import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        rec(n, m,  0, new boolean[n+1], new int[m]);

    }

    public static void rec(int n, int m, int index, boolean[] visited, int[] input) {
        if (index == m) {
            for (int e: input) {
                System.out.print(e + " ");
            }
            System.out.println();
            return;
        }
        for (int i=1; i<=n; i++) {
            if (visited[i]) {
                continue;
            }
            input[index] = i;
            visited[i] = true;
            rec(n, m, index+1, visited, input);
            input[index] = 0;
            visited[i] = false;
        }
    }
}
