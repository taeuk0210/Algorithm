import java.util.Scanner;

public class Main {
    static int answer = 0;
    static int[][] board;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        queen(0);
        System.out.println(answer);
    }

    public static void queen(int depth) {
        if (depth == n) {
            answer++;
            return;
        }
        for (int k=0; k<n; k++) {
            if (board[depth][k] == 0) {
                fillBoard(depth, k, 1);
                queen(depth+1);
                fillBoard(depth, k, -1);
            }
        }
    }

    public static void fillBoard(int i, int j, int d) {
        for (int k=0; k<board.length; k++) {
            board[i][k] += d;
        }
        for (int k=1; k<board.length-i; k++) {
            board[i+k][j] += d;
            if (0<= j-k && j-k < board.length) {
                board[i+k][j-k] += d;
            }
            if (0<= j+k && j+k < board.length) {
                board[i+k][j+k] += d;
            }
        }
    }
}
