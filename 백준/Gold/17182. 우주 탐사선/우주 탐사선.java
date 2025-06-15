import java.util.*;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int[][] arr;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }    
        }
        
        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
       
        boolean[] visited = new boolean[n];
        visited[m] = true;
        backtrack(1, m, 0, visited);
        System.out.println(answer);
    }
    private static void backtrack(int depth, int now, int cost, boolean[] visited) {
        if (depth == visited.length) {
            answer = Math.min(answer, cost);
            return;
        }
        
        for (int next=0; next<visited.length; next++) {
            if (!visited[next]) {
                visited[next] = true;
                backtrack(depth+1, next, cost+arr[now][next], visited);
                visited[next] = false;
            }
        }
        
    }
}