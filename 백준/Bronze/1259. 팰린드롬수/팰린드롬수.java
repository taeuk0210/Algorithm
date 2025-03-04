import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String n = sc.nextLine();
            if (n.equals("0")) break;
            
            boolean isOk = true;
            for (int i=0; i<n.length()/2; i++) {
                if (n.charAt(i) != n.charAt(n.length()-i-1)) {
                    isOk = false;
                    break;
                }
            }
            System.out.println(isOk ? "yes" : "no");
            
        }
    }
}