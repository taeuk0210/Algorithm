import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> a = new HashSet<>();
        for (int i=0; i<n; i++) {
            a.add(sc.nextInt());
        }
        Set<Integer> b = new HashSet<>();
        for (int i=0; i<m; i++) {
            b.add(sc.nextInt());
        }
        
        Set<Integer> a2 = new HashSet<>(a);
        Set<Integer> b2 = new HashSet<>(b);
        a.addAll(b);
        a2.retainAll(b2);
        a.removeAll(a2);
        System.out.println(a.size());
        
    }
}