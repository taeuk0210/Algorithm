import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] hw = sc.nextLine().split(" ");
        int h = Integer.parseInt(hw[0]);
        int w = Integer.parseInt(hw[1]);
        char[][] map = new char[h][w];
        int[][] answer = new int[h][w];
        for (int i = 0; i < h; i++) {
            map[i] = sc.next().toCharArray();
            answer[i] = shift(map[i]);
        }
        Arrays.stream(answer)
                .map(row -> Arrays.stream(row).mapToObj(String::valueOf).reduce((a,b)->a+" "+b).get())
                .forEach(System.out::println);
    }
    public static int[] shift(char[] row) {
        int[] result = new int[row.length];
        Arrays.fill(result, -1);
        int count;
        for (int i = 0; i < row.length; i++) {
            count = 0;
            for (int j = i; j >= 0; j--) {
                if (row[j] == 'c') {
                    result[i] = count;
                    break;
                }
                count++;
            }
        }
        return result;

    }
}
