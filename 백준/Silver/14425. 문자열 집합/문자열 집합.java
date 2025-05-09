import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nk = sc.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        Set<String> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            set.add(sc.nextLine());
        }
        int answer = 0;
        for (int i=0; i<k; i++) {
            if (set.contains(sc.nextLine())) answer++;
        }
        System.out.println(answer);
    }
}