class Solution {
    public int solution(int m, int n, String[] board) {
        String[][] brd = new String[m][n];
        int[][] mask;
        int score, answer = 0;

        for (int i=0; i<m; i++) {
            brd[i] = board[i].split("");
        }
            
        while (true) {
            // viewBoard(brd);
            score = 0;
            mask = new int[m][n];
            for (int i=0; i<m-1; i++) {
                for (int j=0; j<n-1; j++) {
                    if (brd[i][j].equals("0")) continue;
                    if (brd[i][j].equals(brd[i][j+1]) &&
                       brd[i][j].equals(brd[i+1][j]) &&
                       brd[i][j].equals(brd[i+1][j+1])) {
                        mask[i][j] = 1;
                        mask[i][j+1] = 1;
                        mask[i+1][j] = 1;
                        mask[i+1][j+1] = 1;
                    }
                }
            }
            
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (mask[i][j] == 1) {
                        brd[i][j] = "0";
                        score += 1;
                    }
                }
            }
            
            for (int j=0; j<n; j++) {
                String[] column = new String[m];
                int index = m-1;
                for (int i=m-1; i>-1; i--) {
                    if (!brd[i][j].equals("0")) {
                        column[index] = brd[i][j];
                        index--;
                    }
                }
                for (int i=m-1; i>-1; i--) {
                    brd[i][j] = i <= index ? "0" : column[i];
                }
                
            }
            if (score == 0) break;
            answer += score;
        }
        return answer;
    }
    
    public void viewBoard(String[][] board) {
        for (String[] row : board) {
            for (String v : row) {
                System.out.print(v);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}