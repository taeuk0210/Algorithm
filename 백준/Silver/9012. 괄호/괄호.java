import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Stack<Character> stack;
        boolean isVPS;

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            stack = new Stack<>();
            isVPS = true;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    stack.push(s.charAt(j));
                } else if (!stack.isEmpty() && s.charAt(j) == ')') {
                    stack.pop();
                } else if (stack.isEmpty() && s.charAt(j) == ')') {
                    isVPS = false;
                    break;
                }
            }
            if (!stack.isEmpty()) isVPS = false;
            System.out.println(isVPS ? "YES" : "NO");
        }
    }
}