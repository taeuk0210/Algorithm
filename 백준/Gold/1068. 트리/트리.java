import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] node = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int v = Integer.parseInt(sc.nextLine());
        int parent, answer = 0;
        boolean[] deleted = new boolean[n];
        int[] childs;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            parent = queue.poll();
            if (deleted[parent]) continue;
            deleted[parent] = true;
            for (int child = 0; child < n; child++) {
                if (node[child]==parent && !deleted[child]) queue.add(child);
            }
        }

        queue.add(IntStream.range(0, n).filter(i -> node[i] == -1).toArray()[0]);
        while(!queue.isEmpty()) {
            parent = queue.poll();
            if (deleted[parent]) continue;
            deleted[parent] = true;
            final int P = parent;
            childs = IntStream.range(0, n).filter(i -> node[i] == P).toArray();

            if (childs.length == 0 ||
                Arrays.stream(childs)
                        .mapToObj(i -> deleted[i])
                        .reduce((a,b)->a && b).get()){
                answer++;
                continue;
            }
            for (int child = 0; child < n; child++) {
                if (node[child]==parent && !deleted[child]) queue.add(child);
            }
        }
        System.out.println(answer);
    }
}
