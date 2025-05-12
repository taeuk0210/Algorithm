import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        
        Set<String> a = new HashSet<>();
        for (int i=0; i<n; i++) {
            a.add(sc.nextLine());
        }
        Set<String> b = new HashSet<>();
        for (int i=0; i<m; i++) {
            String s = sc.nextLine();
            if (a.contains(s)) {
                b.add(s);
            }
        }
        List<String> list = new ArrayList<>(b);
        Collections.sort(list);
        System.out.println(list.size());
        for (String st: list) {
            System.out.println(st);
        }
    }
}