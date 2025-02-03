import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n==0) {
                if (queue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(queue.poll()[1]);
                }
            } else {
                queue.add(new int[] { n>0 ? n : -n, n });
            }
        }
    }
}
