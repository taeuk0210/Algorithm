class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int x, y, z;
        for (int i=0; i<quiz.length; i++) {
            String[] w = quiz[i].split(" ");
            x = Integer.parseInt(w[0]);
            y = Integer.parseInt(w[2]);
            z = Integer.parseInt(w[4]);
            if (w[1].equals("+")) {
                answer[i] = (x+y)==z ? "O" : "X";
            } else {                
                answer[i] = (x-y)==z ? "O" : "X";
            }
            
        }
        return answer;
    }
}