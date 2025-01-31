
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] scores = new int[2];
        int[] times = new int[2];
        int prevTime = 0;
        int[] goal;

        for (int i = 0; i < n; i++) {
            goal = input(sc.nextLine());
            if (scores[0] > scores[1]) {
                times[0] += goal[1] - prevTime;
            } else if (scores[0] < scores[1]) {
                times[1] += goal[1] - prevTime;
            }
            prevTime = goal[1];
            scores[goal[0]-1] += 1;
        }
        if (scores[0] > scores[1]) {
            times[0] += 48*60 - prevTime;
        } else if (scores[0] < scores[1]) {
            times[1] += 48*60 - prevTime;
        }
        System.out.println(output(times[0]));
        System.out.println(output(times[1]));
    }
    public static String output(int m) {
        return (m/60 > 9 ? "" : "0") + m/60 + ":" +
               (m%60 > 9 ? "" : "0") + m%60;
    }
    public static int[] input(String input) {
        String[] tokens = input.split(" ");
        int[] times = Arrays.stream(tokens[1].split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return new int[] {
                Integer.parseInt(tokens[0]),
                60 * times[0] + times[1]
        };
    }
}
