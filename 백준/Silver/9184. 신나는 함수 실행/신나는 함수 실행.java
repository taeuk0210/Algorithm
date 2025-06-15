import java.util.*;

public class Main {
    static int[][][] w = new int[101][101][101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a==-1 && b == -1 && c == -1) {
                break;
            }
            System.out.println("w(" + a+ ", "+b+", "+c+") = " + w(a,b,c));
        }
    }    
    
    private static int getIndex(int a) {
        return 2 * Math.abs(a) + (a < 0 ? -1 : 0);
    }
    
    private static int w(int a, int b, int c) {
        if (w[getIndex(a)][getIndex(b)][getIndex(c)] != 0) {
            return w[getIndex(a)][getIndex(b)][getIndex(c)];
        } else {
            if (a<=0 || b<=0 || c<=0) {
                w[getIndex(a)][getIndex(b)][getIndex(c)] = 1;
                return 1;
            } else if (a>20 || b>20 || c>20) {
                w[getIndex(a)][getIndex(b)][getIndex(c)] = w(20,20,20);
                return w(20,20,20);
            } else if (a<b && b<c) {
                int v = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
                w[getIndex(a)][getIndex(b)][getIndex(c)] = v;
                return v;
            } else {
                int v = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
                w[getIndex(a)][getIndex(b)][getIndex(c)] = v;
                return v;
            }
        }
    }
}