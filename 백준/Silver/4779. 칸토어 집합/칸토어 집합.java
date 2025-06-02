import java.util.*;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int num = sc.nextInt();
            int n = (int)Math.pow(3, num);
            sb = new StringBuilder("-".repeat(n));
            rec(0, n);
            System.out.println(sb.toString());
        }
        
    }
    
     public static void rec(int s, int len) {
        if (len < 3) return;
        int third = len / 3;
        for (int i = s + third; i < s + 2 * third; i++) {
            sb.setCharAt(i, ' '); 
        }
        rec(s, third);
        rec(s + 2 * third, third);
    }
}