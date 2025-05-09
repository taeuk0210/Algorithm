import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Set<String> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            String[] str = sc.nextLine().split(" ");
            if (str[1].equals("enter")) {
                set.add(str[0]);
            } else {
                set.remove(str[0]);
            }
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Comparator.reverseOrder());
        for (String name: list) {
            System.out.println(name);
        }
    }
}