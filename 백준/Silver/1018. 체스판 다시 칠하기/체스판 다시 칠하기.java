import java.util.*;

public class Main {
    static int answer = 2500;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        char[][] b = new char[n][m];
        for (int i=0; i<n; i++) {
            b[i] = sc.nextLine().toCharArray();
        }

        for (int i=0; i<n-7; i++) {
            for (int j=0; j<m-7; j++) {
                scan(b, i, j, 'B');
                scan(b, i, j, 'W');
            }
        }
        System.out.println(answer);

    }

    public static void scan(char[][] b, int y, int x, char s) {
        int count = 0;
        for(int i=y; i<y+8; i++) {
            for (int j=x; j<x+8; j++) {
                char a = (i-y)%2==(j-x)%2 ? s : (s=='B' ? 'W' : 'B');
                if (b[i][j] != a) {
                    count++;
                }
            }
        }
        answer = Math.min(count, answer);
    }
}