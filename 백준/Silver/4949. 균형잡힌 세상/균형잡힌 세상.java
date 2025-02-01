import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack;
        while (sc.hasNextLine()) {
            String s = "";
            while (sc.hasNextLine()) {
                s += sc.nextLine();
                if (s.endsWith(".")) {
                    break;
                }
            }
            if (s.equals(".")) break;

            stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (!stack.isEmpty() && stack.peek()=='(' && c == ')') {
                    stack.pop();
                } else if (!stack.isEmpty() && stack.peek()=='[' && c == ']') {
                    stack.pop();
                } else if ((!stack.isEmpty() && stack.peek()=='[' && c == ')')||
                        (!stack.isEmpty() && stack.peek()=='(' && c == ']')) {
                    break;
                } else if (stack.isEmpty() && (c==')' || c==']')) {
                    stack.push(c);
                    break;
                }
            }
            System.out.println(stack.isEmpty() ? "yes" : "no");
        }
    }
}
