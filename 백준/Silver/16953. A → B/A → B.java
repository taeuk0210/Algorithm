import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[] {a, 1});
        long answer = -1;
        while (!queue.isEmpty()) {
            long[] data = queue.poll();
            long n = data[0];
            long cost = data[1];
            if (n==b) {
                answer = cost;
                break;
            }
            for (long next : new long[] {2*n, 10*n+1}) {
                if (next <= b) {
                    queue.add(new long[] {next, cost + 1});
                }
            }
        }
        System.out.println(answer);
    }
}
