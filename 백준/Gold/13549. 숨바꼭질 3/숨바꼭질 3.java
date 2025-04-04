import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = Math.max(n, k);
        boolean[] visited = new boolean[2*m + 1];
        Deque<int[]> deque = new LinkedList<>();
        deque.offerFirst(new int[] {n, 0});
        visited[n] = true;
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int c = cur[0];
            int cost = cur[1];
            if (c == k) {
                System.out.println(cost);
                return;
            }
            for (int next: new int[] {c-1, c+1, c*2}) {
                if (0 <= next && next <= 2*m && !visited[next]) {
                    if (2*c == next) {
                        deque.offerFirst(new int[] {next, cost});
                    } else {
                        deque.offerLast(new int[] {next, cost+1});
                    }
                    visited[next] = true;
                }
            }
        }
    }
}
