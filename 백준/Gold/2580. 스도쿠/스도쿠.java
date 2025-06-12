import java.util.*;

public class Main {
    static int[][] arr = new int[9][9];
    static List<int[]> pos = new ArrayList<>();
    static boolean[][] row = new boolean[9][10];
    static boolean[][] col = new boolean[9][10];
    static boolean[][] box = new boolean[9][10];
    static boolean solved = false;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 0) {
                    pos.add(new int[] {i, j});
                } else {
                    row[i][arr[i][j]] = true;
                    col[j][arr[i][j]] = true;
                    box[boxIndex(i, j)][arr[i][j]] = true;
                }
            }    
        }
        rec(0);
    }
    
    private static int boxIndex(int i, int j) {
        return (i / 3) * 3 + (j / 3);
    }
    
    private static void rec(int depth) {
        if (solved) return;
        if (depth == pos.size()) { 
            for (int[] row: arr) {
                for (int r: row) {
                    System.out.print(r+" ");
                }
                System.out.println();
            }
            solved = true;
            return;
        }
        int[] cur = pos.get(depth);
        int r = cur[0];
        int c = cur[1];
        int b = boxIndex(r, c);
        for (int i=1; i<=9; i++) {
            if (row[r][i] || col[c][i] || box[b][i]) continue;
            
            arr[r][c] = i;
            row[r][i] = col[c][i] = box[b][i] = true;
            rec(depth+1);
            arr[r][c] = 0;
            row[r][i] = col[c][i] = box[b][i] = false;
        }
    }
}