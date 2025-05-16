import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        for (int i=1; i<=n; i++) {
            String name = sc.nextLine();
            map.put(name, String.valueOf(i));
            map.put(String.valueOf(i), name);
        }
        
        for (int i=0; i<m; i++) {
            System.out.println(map.get(sc.nextLine()));
        }
        
        
    }
}