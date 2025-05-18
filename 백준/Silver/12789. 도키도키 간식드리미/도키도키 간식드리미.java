import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int next = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            int current = sc.nextInt();
            if (current != next) {
                stack.push(current);
            } else {
                next++;
                while (!stack.isEmpty() && stack.peek() == next) {
                    stack.pop();
                    next++;
                }
            }
            
        }
        System.out.print(stack.isEmpty() ? "Nice" : "Sad");
    }
}