import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> answer = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            q.offer(i);
        }
        while (!q.isEmpty()) {
            for (int i=1; i<k; i++) {
                q.offer(q.poll());
            }
            answer.offer(q.poll());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (answer.size() > 1) {
            sb.append(answer.poll()+", ");
        }
        sb.append(answer.poll()+">");
        System.out.println(sb);
    }
}