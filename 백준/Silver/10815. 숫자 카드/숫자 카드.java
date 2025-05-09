import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            set.add(sc.nextInt());
        }
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<k; i++) {
            sb.append(set.contains(sc.nextInt()) ? 1 : 0).append(" ");
        }
        System.out.println(sb);
    }
}