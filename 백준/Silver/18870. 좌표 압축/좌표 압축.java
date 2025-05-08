import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            b[i] = a[i];
        }
        Arrays.sort(b);
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i=0; i<n; i++) {
            if (!map.containsKey(b[i])) {
                map.put(b[i], count++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k: a) {
            sb.append(map.get(k)).append(" ");
        }
        System.out.print(sb);
    }
}