import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            String str = sc.nextLine();
            if (str.startsWith("1")) {
                stack.push(Integer.parseInt(str.split(" ")[1]));
                continue;
            }
            int command = Integer.parseInt(str);
            switch (command) {
                case 2:
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 5:
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}