import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int s = 0;
        while (sc.hasNextInt()) {
            s += sc.nextInt();
        }
        System.out.println(s);
    }
}