import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exper = sc.nextLine();
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        String n = "";
        int sign = 1;
        for (int i = 0; i < exper.length(); i++) {
            if (exper.charAt(i) == '+') {
                stack.push(Integer.parseInt(n));
                n = "";
            } else if (exper.charAt(i) == '-') {
                stack.push(Integer.parseInt(n));
                n = "";
                while(!stack.isEmpty()) {
                    answer += sign * stack.pop();
                }
                sign = -1;
            } else {
                n += exper.charAt(i);
            }
        }
        if (n.length() > 0) {
            stack.push(Integer.parseInt(n));
        }
        while (!stack.isEmpty()) {
            answer += sign * stack.pop();
        }
        System.out.println(answer);
    }
}