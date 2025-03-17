import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int N = Math.max(n, k);
        int[] distance = new int[2*N+1];
        boolean[] visited = new boolean[2*N+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        while (!queue.isEmpty()) {
            int c = queue.poll();
            if (c == k) {
                break;
            }
            for (int next : new int[] {c-1, c+1, 2*c}) {
                if (0<=next && next<2*N && !visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[c] + 1;
                    queue.add(next);
                }
            }
        }
        System.out.print(distance[k]);
    }
}
