import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] queue = new int[n];
        for (int i=0; i<n; i++) {
            queue[i] = sc.nextInt();
        }
        
        List<Integer> list = new ArrayList<>();
        int current = 0;
        int next = queue[current];
        queue[current] = 0;
        list.add(current + 1);
        while (list.size() < n) {
            int d = next > 0 ? 1 : -1;
            int count = 0;
            while (count < next * d) {
                current = (current + d + n) % n;
                if (queue[current] != 0) {
                    count++;
                }
            }
            next = queue[current];
            queue[current] = 0;
            list.add(current + 1);
        }
        for (int a: list) {
            System.out.print(a + " ");
        }
        
    }
}