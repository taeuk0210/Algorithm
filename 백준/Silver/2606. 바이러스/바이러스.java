import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(sc.nextLine());
        for (int i=0; i<m; i++) {
            String[] input = sc.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int current, answer = 0;
        while (!queue.isEmpty()) {
            current = queue.poll();
            for (int next: graph[current]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
