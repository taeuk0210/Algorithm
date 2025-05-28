import java.util.*;

public class Main {
    static int calls;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i=0; i<n; i++) {
            String str = sc.nextLine();
            System.out.println(isPalindrome(str)+" "+calls);
        }
    }
    
    private static int rec(String str, int left, int right) {
        calls++;
        if (left >= right) return 1;
        else if (str.charAt(left) != str.charAt(right)) return 0;
        else return rec(str, left+1, right-1);
    }
    
    private static int isPalindrome(String str) {
        calls = 0;
        return rec(str, 0, str.length() - 1);
    }
}