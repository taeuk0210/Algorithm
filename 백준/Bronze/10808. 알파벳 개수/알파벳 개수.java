import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        int[] arr = new int[26];
        for (int i=0; i<str.length; i++) {
            arr[(int)(str[i] - 'a')]++;
        }
        for (int a: arr) {
            System.out.print(a + " ");
        }
    }
}