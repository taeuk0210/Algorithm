import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        List<List<int[]>> graph = getGraph(n, fares);
        int[] cost = dist(s, n, graph);
        int[] argSort = IntStream.rangeClosed(0, n)
            .boxed()
            .sorted((i, j) -> Integer.compare(cost[i] ,cost[j]))
            .mapToInt(i -> i)
            .toArray();
        for (int i: argSort) {
            if (answer <= cost[i]) {
                continue;
            }
            int[] subCost = dist(i, n, graph);
            answer = Math.min(subCost[a] + subCost[b] + cost[i], answer);
            
        }
        return answer;
    }
    
    private List<List<int[]>> getGraph(int n, int[][] fares) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] fare: fares) {
            int u = fare[0];
            int v = fare[1];
            int w = fare[2];
            graph.get(u).add(new int[] {v, w});
            graph.get(v).add(new int[] {u, w});
        }
        return graph;
    }
    
    private int[] dist(int start, int n, List<List<int[]>> graph) {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, 100_000_001);
        cost[start] = 0;
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        queue.offer(new int[] {start, 0});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            if (current[1] > cost[current[0]]) {
                continue;
            }
            
            for (int[] next: graph.get(current[0])) {
                if (cost[next[0]] > cost[current[0]] + next[1]) {
                    cost[next[0]] = cost[current[0]] + next[1];
                    queue.offer(new int[] {next[0], cost[next[0]]});
                }
            }
        }
        return cost;
        
    }
    
}