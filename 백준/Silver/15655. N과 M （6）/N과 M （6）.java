import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        rec(0, 0, new boolean[n], new int[m]);
        System.out.print(sb);
    }

    public static void rec(int s, int index, boolean[] visited, int[] input) {
        if (index == m) {
            sb.append(Arrays.toString(input).replaceAll("[\\[\\],]", ""))
                    .append("\n");
            return;
        }
        for (int i=s; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                input[index] = nums[i];
                rec(i+1, index + 1, visited, input);
                visited[i] = false;
                input[index] = 0;
            }
        }
    }
}
