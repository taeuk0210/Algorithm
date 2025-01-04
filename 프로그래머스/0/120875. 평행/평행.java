class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        double m1, m2;
        int[][] index = new int[][] {{0,1,2,3}, {0,2,1,3}, {0,3,1,2}};
        for (int[] i : index) {
            m1 = (double)(dots[i[0]][1] - dots[i[1]][1]) / (dots[i[0]][0] - dots[i[1]][0]);
            m2 = (double)(dots[i[2]][1] - dots[i[3]][1]) / (dots[i[2]][0] - dots[i[3]][0]);
            if (m1 == m2) answer++;
        }
        return answer > 0 ? 1 : 0;
    }
}