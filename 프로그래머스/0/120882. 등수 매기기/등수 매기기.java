import java.util.stream.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] argsort = IntStream.range(0, score.length)
            .boxed()
            .sorted((i, j) -> sum(score, j) - sum(score,i))
            .mapToInt(Integer::intValue)
            .toArray();
        
        int[] answer = new int[score.length];
        int rank = 1;
        int s = 0;
        for (int i=0; i<argsort.length; i++) {
            if (i > 0 && sum(score, argsort[i]) != sum(score, argsort[i-1])) {
                rank += s+1;
                s=0;
            } else if (i > 0 && sum(score, argsort[i]) == sum(score, argsort[i-1])) {
                s++;
            }
            answer[argsort[i]] = rank;
        }
        return answer;
    }
    public int sum(int[][] score, int i) {
        return score[i][0] + score[i][1];
    }
}