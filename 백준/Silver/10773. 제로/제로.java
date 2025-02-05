import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            int n = sc.nextInt();
            if (n > 0) stack.push(n);
            else stack.pop();
        }
        int s = 0;
        while (!stack.isEmpty()) {
            s += stack.pop();
        }
        System.out.print(s);
    }
}
