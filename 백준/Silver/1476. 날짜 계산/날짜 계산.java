import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] target = new int[3];
        int[] day = new int[3];
        Arrays.fill(day, 1);
        for (int i=0; i<3; i++) {
            target[i] = sc.nextInt();
        }
        int count = 1;
        while (day[0] != target[0] ||
               day[1] != target[1] ||
               day[2] != target[2]) {
            day[0] = (day[0]) % 15 + 1;
            day[1] = (day[1]) % 28 + 1;
            day[2] = (day[2]) % 19 + 1;
            
            count++;
        }
        System.out.println(count);
        
    }
}