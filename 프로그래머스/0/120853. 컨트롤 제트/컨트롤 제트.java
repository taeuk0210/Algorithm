class Solution {
    public int solution(String s) {
        int answer = 0;
        int prev = 0;
        for (String n : s.split(" ")) {
            if (n.equals("Z")) {
                answer -= prev;
            } else {
                prev = Integer.parseInt(n);
                answer += prev;
            }
        }
        return answer;
    }
}