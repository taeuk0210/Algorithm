import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] c = new int[6];
        for (int i=0; i<6; i++) {
            c[i] = sc.nextInt();
        }
        for (int x=-999; x<=999; x++) {
            for (int y=-999; y<=999; y++) {
                if (c[0]*x+c[1]*y==c[2] && c[3]*x+c[4]*y==c[5]) {
                    System.out.println(x+" "+y);
                }
            }
        }
    }
}