import java.util.*;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        answer = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }
        System.out.println(answer);
    }
    public static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        answer++;
    }
}
