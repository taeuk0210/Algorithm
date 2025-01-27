import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nmv = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = nmv[0], m = nmv[1], v = nmv[2];

        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] e = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        for (int i=1; i<=n; i++) Collections.sort(graph[i]);

        StringBuilder dfs = new StringBuilder();
        StringBuilder bfs = new StringBuilder();

        boolean[] visited = new boolean[n+1];
        dfs(v, graph, visited, dfs);

        Arrays.fill(visited, false);
        bfs(v, graph, visited, bfs);

        System.out.print(dfs.toString().strip() + "\n" + bfs.toString().strip());
    }

    private static void dfs(int node, List<Integer>[] graph, boolean[] visited, StringBuilder result) {
        visited[node] = true;
        result.append(node).append(" ");
        for (int next : graph[node]) {
            if (!visited[next]) dfs(next, graph, visited, result);
        }
    }

    private static void bfs(int start, List<Integer>[] graph, boolean[] visited, StringBuilder result) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.append(node).append(" ");
            for (int next : graph[node]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
