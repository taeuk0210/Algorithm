import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        rec(n, m, 1, 0, new int[m]);
        System.out.print(sb);
    }

    public static void rec(int n, int m, int s, int index, int[] input) {
        if (index == m) {
            sb.append(Arrays.toString(input).replaceAll("[\\[\\],]", ""))
                .append("\n");
            return;
        }
        for (int i=s; i<=n; i++) {
            input[index] = i;
            rec(n, m, i, index+1, input);
            input[index] = 0;
        }
    }
}
