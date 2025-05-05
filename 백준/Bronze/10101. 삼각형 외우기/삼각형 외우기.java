import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<3; i++) {
            int a = sc.nextInt();
            set.add(a);
            sum += a;
        }
        if (sum != 180) {
            System.out.println("Error");
        } else {
            if (set.size() == 1) {
                System.out.println("Equilateral");
            } else if (set.size() == 2) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}