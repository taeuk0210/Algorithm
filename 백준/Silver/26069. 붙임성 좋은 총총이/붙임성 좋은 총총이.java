import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        for (int i=0; i<n; i++) {
            String[] str = sc.nextLine().split(" ");
            if (set.contains(str[0])) set.add(str[1]);
            if (set.contains(str[1])) set.add(str[0]);
        }
        System.out.println(set.size());
    }
}