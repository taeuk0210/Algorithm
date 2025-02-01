import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static int[] count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            tree[B].add(A);
        }

        count = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        int maxCount = Arrays.stream(count).max().getAsInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (count[i] == maxCount) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static void bfs(int start) {
        boolean[] visited = new boolean[tree.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        int cnt = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            cnt++;
            for (int next : tree[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        count[start] = cnt;
    }
}
