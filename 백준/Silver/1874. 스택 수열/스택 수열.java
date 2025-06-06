import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            int next = sc.nextInt();
            if (!stack.isEmpty() && stack.peek() == next) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                while (stack.isEmpty() || stack.peek() < next) {
                    stack.push(num++);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            } 
        }
        
        if (stack.isEmpty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}