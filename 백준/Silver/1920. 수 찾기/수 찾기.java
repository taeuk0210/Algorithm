import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        Set<Integer> set = new HashSet<>();
        Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(i -> set.add(i));
        sc.nextLine();
        Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(i ->System.out.println(
                        set.contains(i) ? 1 : 0));
        sc.close();
    }
}
