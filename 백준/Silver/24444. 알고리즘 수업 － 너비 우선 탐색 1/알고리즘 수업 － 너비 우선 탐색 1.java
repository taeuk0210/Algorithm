import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            graph[i].sort((a, b) -> a - b);
        }
        int[] visited = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = 1;
        int ord = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (visited[next] == 0) {
                    queue.add(next);
                    visited[next] = ++ord;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(visited[i]);
        }
    }
}
