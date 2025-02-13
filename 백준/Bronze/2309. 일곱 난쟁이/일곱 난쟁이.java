import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static int[] answer = new int[7];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        rec(0, new int[7], new boolean[9]);

        Arrays.stream(answer)
                .map(i->arr[i])
                .sorted()
                .forEach(System.out::println);
    }


    public static void rec(int index, int[] input, boolean[] visited) {
        if (index == 7) {
            if (Arrays.stream(input).map(i->arr[i]).sum()==100) {
                answer = Arrays.copyOf(input, 7);
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                input[index] = i;
                rec(index + 1, input, visited);
                visited[i] = false;
                input[index] = 0;
            }
        }
    }
}
