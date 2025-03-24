import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        int s = Integer.parseInt(br.readLine());

        int[] distance = new int[V + 1];
        Arrays.fill(distance, 200000);

        List<int[]>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<E; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            graph[a].add(new int[] {b, c});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[1])
        );
        queue.add(new int[] { s, 0 });
        distance[s] = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int now = current[0];
            int dist = current[1];
            if (dist > distance[now]) {
                continue;
            }
            for (int[] next: graph[now]) {
               if (distance[next[0]] > distance[now] + next[1]) {
                   distance[next[0]] = distance[now] + next[1];
                   queue.add(new int[] {next[0], distance[next[0]]});
               }
            }
        }
        for (int i=1; i<=V; i++) {
            System.out.println(distance[i]==200000 ? "INF" : distance[i]);
        }
    }
}
