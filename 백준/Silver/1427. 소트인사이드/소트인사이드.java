import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        
        int[] a = new int[10];
        for (int i=0; i<n.length(); i++) {
            a[(int) (n.charAt(i) - '0')]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=9; i>=0; i--) {
            sb.append(String.valueOf(i).repeat(a[i]));
        }
        System.out.println(sb);
        
        
    }
}