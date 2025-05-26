import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int answer = 0;
        Set<String> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            String str = sc.nextLine();
            if (str.equals("ENTER")) {
                answer += set.size();
                set.clear();
            } else {
                set.add(str);
            }
        }
        System.out.println(answer+set.size());
    }
}