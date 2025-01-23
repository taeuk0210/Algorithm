class Solution {
    public int solution(String my_string) {
        String[] op = my_string.split(" ");
        int answer = Integer.parseInt(op[0]);
        for (int i=1; i<op.length-1; i+=2) {
            answer += op[i].equals("+") ? 
                Integer.parseInt(op[i+1]) :  
                -Integer.parseInt(op[i+1]);
        }
        return answer;
    }
}