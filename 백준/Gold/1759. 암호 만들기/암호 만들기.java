import java.util.*;

public class Main {
    static List<String> list = new ArrayList<>();
    static Set<String> set = new HashSet<>();
    static String[] str;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine().split(" ");
        int l = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);
        str = sc.nextLine().split(" ");
        set.addAll(List.of("a", "e", "i", "o", "u"));
        Arrays.sort(str);
        
        backtrack(0, new int[l], 0);
        for (String e: list) {
            System.out.println(e);
        }
    }
    
    private static void backtrack(int depth, int[] current, int start) {
        if (depth == current.length) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<current.length; i++) {
                sb.append(str[current[i]]);
                if (set.contains(str[current[i]])) count++;
            }
            if (count > 0 && current.length - count > 1) list.add(sb.toString());
            return;
        }
        
        for (int i=start; i<str.length; i++) {
            current[depth] = i;
            backtrack(depth+1, current, i+1);
            current[depth] = 0;
        }
    }
}