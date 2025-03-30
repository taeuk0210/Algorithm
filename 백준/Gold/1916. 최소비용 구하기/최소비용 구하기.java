import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int start;
    static int end;
    static List<int[]>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[s].add(new int[] {e, c});
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
 int[] distance = new int[N+1];
        Arrays.fill(distance, 100000000);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[1])
        );
        pq.add(new int[] {start, 0});
        distance[start] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int current = cur[0];
            int cost = cur[1];
            if (current == end) {
                System.out.println(cost);
                return;
            }
            for (int[] next: graph[current]) {
                if (distance[next[0]] > next[1] + cost) {
                    distance[next[0]] = next[1] + cost;
                    pq.add(new int[] {next[0], cost + next[1]});
                }
            }
        }
    }
}
