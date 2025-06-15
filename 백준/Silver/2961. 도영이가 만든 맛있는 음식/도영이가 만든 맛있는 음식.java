import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        arr = new int[n][2];
        for (int i=0; i<n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        
        for (int k=1; k<=n; k++){
            backtrack(0, 0, new int[k]);
        }
        System.out.println(answer);
    }
    private static void backtrack(int depth, int start, int[] current) {
        if (depth == current.length) {
            int s = 1, b = 0;
            for (int i=0; i<depth; i++) {
                s *= arr[current[i]][0];
                b += arr[current[i]][1];
            }
            answer = Math.min(answer, Math.abs(s-b));
            return;
        }
        
        for (int i=start; i<n; i++) {
            current[depth] = i;
            backtrack(depth+1, i+1, current);
            current[depth] = 0;
        }
    }
}