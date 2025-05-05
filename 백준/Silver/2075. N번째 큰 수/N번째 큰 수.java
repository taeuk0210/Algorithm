import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<PriorityQueue<Integer>> queue = new PriorityQueue<>(
                (a,b) -> b.peek() - a.peek()
        );
        for (int i = 0; i < n; i++) {
            PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
            for (int j = 0; j < n; j++) {
                q.add(sc.nextInt());
            }
            queue.add(q);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            PriorityQueue<Integer> q = queue.poll();
            answer = q.poll();
            queue.add(q);
        }
        System.out.println(answer);

    }
}
