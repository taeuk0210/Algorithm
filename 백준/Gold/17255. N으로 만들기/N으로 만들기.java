import java.util.*;

public class Main {
    static String target;
    static Set<String> pieceSet = new HashSet<>();
    static Set<String> digitSet = new HashSet<>();
    static List<String> digits;
    static Set<String> pathSet = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        target = sc.nextLine();
        pieceSet = new HashSet<>();
        digitSet = new HashSet<>();
        for (int i=0; i<target.length(); i++) {
            digitSet.add(target.substring(i, i+1));
            for (int j=i+1; j<target.length()+1; j++) {
                pieceSet.add(target.substring(i, j));
            }    
        }
        digits = new ArrayList<>(digitSet);
        
        backtrack(0, "", new String[target.length()]);
        System.out.println(pathSet.size());
        
    }
    
    private static void backtrack(int depth, String current, String[] path) {
        if (current.length() == target.length()) {
            if (current.equals(target)) {
                pathSet.add(String.join(":", path));
            }
            return;
        }
        
        for (String d: digits) {
            String next = current + d;
            if (pieceSet.contains(next)) {
                path[depth] = next;
                backtrack(depth+1, next, path);
            }
            next = d + current;
            if (pieceSet.contains(next)){
                path[depth] = next;
                backtrack(depth+1, next, path);
            }
        }
        
    }
}