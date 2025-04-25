import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            queue.offer(sc.nextInt());
        }
        
        int answer = 0;
        while (true) {
            Integer a = queue.poll();
            Integer b = queue.poll();
            if (b == null) {
                break;
            }
            answer += (a+b);
            queue.offer(a+b);
        }
        System.out.println(answer);
        
    }
}