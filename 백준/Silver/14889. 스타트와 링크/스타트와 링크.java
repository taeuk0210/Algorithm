import java.util.stream.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        rec(0, 0, new int[n/2]);

        System.out.println(answer/2);

    }

    private static int power(int[] team) {
        int s = 0;
        for (int i=0; i<team.length; i++) {
            for (int j=0; j<team.length; j++) {
                if (i != j) {
                    s += arr[team[i]][team[j]];
                    s += arr[team[j]][team[i]];
                }
            }
        }
        return s;
    }

    private static void rec(int depth, int start, int[] teamA) {
        if (depth == n/2) {
            Set<Integer> set = new HashSet<>(IntStream.range(0, n).boxed().collect(Collectors.toList()));
            set.removeAll(Arrays.stream(teamA).boxed().collect(Collectors.toSet()));
            int[] teamB = set.stream().mapToInt(i -> i).toArray();
            answer = Math.min(answer, Math.abs(power(teamB) - power(teamA)));
            return;
        }
        for (int i=start; i<n; i++) {
            teamA[depth] = i;
            rec(depth+1, i+1, teamA);
        }
    }
}