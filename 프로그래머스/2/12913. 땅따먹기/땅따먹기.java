class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int max;
        for (int i=1; i<land.length; i++) {
            for (int crnt=0; crnt<4; crnt++) {
                max = 0;
                for (int prev=0; prev<4; prev++) {
                    if (prev != crnt) {
                        if (max < land[i-1][prev] + land[i][crnt]) {
                            max = land[i-1][prev] + land[i][crnt];
                        }
                    }
                }
                land[i][crnt] = max;
            }
        }
        for (int value : land[land.length-1]) {
            if (value > answer) {
                answer = value;
            }
        }
        return answer;
    }
}