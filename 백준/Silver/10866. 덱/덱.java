import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("front")) {
                sb.append(!deque.isEmpty() ? deque.peekFirst() : -1).append("\n");
            } else if (cmd.equals("back")) {
                sb.append(!deque.isEmpty() ? deque.peekLast() : -1).append("\n");
            } else if (cmd.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else if (cmd.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (cmd.equals("pop_back")) {
                sb.append(!deque.isEmpty() ? deque.pollLast() : -1).append("\n");
            } else if (cmd.equals("pop_front")) {
                sb.append(!deque.isEmpty() ? deque.pollFirst() : -1).append("\n");
            } else {
                int x = Integer.parseInt(st.nextToken());
                if (cmd.equals("push_front")) {
                    deque.offerFirst(x);
                } else if (cmd.equals("push_back")) {
                    deque.offerLast(x);
                }
            }
        }
        System.out.println(sb);
    }
}