import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextLine());
        }

        set.stream().sorted((a,b) ->
            a.length() != b.length() ?
            a.length() - b.length() :
            a.compareTo(b)
        ).forEach(System.out::println);
    }
}
