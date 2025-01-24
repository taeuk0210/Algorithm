import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[5][15];
        String str;
        for (int i=0; i<5; i++) {
            str = sc.nextLine();
            for (int j=0; j<15; j++) {
                arr[i][j] = j < str.length() ? str.charAt(j) : ' ';
            }
        }

        for (int j=0; j<15; j++) {
            for (int i=0; i<5; i++) {
                if (arr[i][j] != ' ') {
                    System.out.print(arr[i][j]);
                }

            }
        }
    }
}