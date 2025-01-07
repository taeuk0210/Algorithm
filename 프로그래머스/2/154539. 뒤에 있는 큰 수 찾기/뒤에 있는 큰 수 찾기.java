import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        answer[numbers.length-1] = -1;
        Stack<Integer> stack = new Stack<>();
        
        for (int i=numbers.length-2; i>=0; i--) {
            if (numbers[i] < numbers[i+1]) {
                stack.push(numbers[i+1]);
                answer[i] = stack.peek();
            } else {
                while (!stack.isEmpty() && stack.peek() <= numbers[i]) stack.pop();  
                answer[i] = stack.size()==0 ? -1 : stack.peek();
            }
        }
        return answer;
    }
}