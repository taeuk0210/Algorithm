import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Set<String> set = new HashSet<>();
        
        for (int i=0; i<str.length(); i++) {
            for (int j=i+1; j<str.length()+1; j++) {
                set.add(str.substring(i, j));
            }
        }
        System.out.println(set.size());
    }
}