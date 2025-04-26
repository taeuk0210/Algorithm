import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i=0; i<n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(arr[0][1]);
        for (int i=1; i<n; i++) {
            if (arr[i][0] >= queue.peek()) {
                queue.poll();
            }
            queue.offer(arr[i][1]);
        }
        
        System.out.println(queue.size());
        
        
    }
}