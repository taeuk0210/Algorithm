import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] isStack = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            isStack[i] = Integer.parseInt(st.nextToken());
        }
        int[] queuestack = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            queuestack[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i=0; i<n; i++) {
            if (isStack[i] == 0) {
                deque.offerLast(queuestack[i]);
            }
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<m;i++) {
            deque.offerFirst(Integer.parseInt(st.nextToken()));
            sb.append(deque.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}