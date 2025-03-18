import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] hit;
    static int[] input;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        hit = new int[N][9];
        visited = new boolean[9];
        input = new int[9];
        answer = 0;
        for (int i = 0; i < N; i++) {
            hit[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        input[3] = 0;
        visited[0] = true;
        rec(0);
        System.out.println(answer);
    }

    public static void solve() {
        int base, player = 0, score = 0, count, h;
        for (int i=0; i<N; i++) {
            base = 0;
            count = 0;
            while (count < 3) {
                h = hit[i][input[player++ % 9]];
                if (h == 0) {
                    count++;
                    continue;
                }
                base = (base << h) | (1 << (h-1));
                score += Integer.bitCount(base >> 3);
                base &= 7;
            }
        }
        answer = Math.max(answer, score);
    }

    public static void rec(int index) {
        if (index == 9) {
            solve();
            return;
        }
        if (index == 3) {
            rec(index + 1);
            return;
        }
        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                input[index] = i;
                rec(index + 1);
                visited[i] = false;
                input[index] = 0;
            }
        }
    }
}
