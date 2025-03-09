import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.startsWith("push")) {
                stack.push(Integer.parseInt(input.split(" ")[1]));
            } else {
                switch (input) {
                    case "pop":
                        System.out.println(stack.isEmpty() ? -1 : stack.pop());
                        break;
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "empty":
                        System.out.println(stack.isEmpty() ? 1 : 0);
                        break;
                    default:
                        System.out.println(stack.isEmpty() ? -1 : stack.peek());
                }
            }
        }
    }
}
