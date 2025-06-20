import java.util.*;

public class Main {  
    static int n;
    static int m;
    static int r;
    static List<Integer>[] graph;
    static int[] visited;
    static int order = 1;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        graph = new ArrayList[n+1];
        
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for (int i=1; i<=n; i++) {
            Collections.sort(graph[i]);
        }
        
        visited = new int[n+1];
        visited[r] = order++;
        dfs(r);
        
        for(int i=1; i<=n; i++) {
            System.out.println(visited[i]);
        }
    }
    private static void dfs(int start) {
        for (int next: graph[start]) {
            if (visited[next] == 0) {
                visited[next] = order++;
                dfs(next);
            }
        }
    }
}