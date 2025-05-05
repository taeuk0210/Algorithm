import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int max = 0;
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            for (int i=0; i<3; i++) {
                int n = sc.nextInt();
                max = Math.max(max, n);
                sum += n;
                set.add(n);
            }
            if (max == 0) {
                break;
            }
            if (2*max >= sum) {
                System.out.println("Invalid");
            } else {
                if (set.size()==1) {
                    System.out.println("Equilateral");
                } else if (set.size()==2) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            }
        }
    }
}