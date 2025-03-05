import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int s=0, e=0;
        List<Integer> q = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            String input = sc.nextLine();
            if (input.startsWith("push")) {
                q.add(Integer.parseInt(input.split(" ")[1]));
                e++;
            } else {
                switch (input) {
                    case "front":
                        System.out.println(s==e ? -1 : q.get(s));
                        break;
                    case "back":
                        System.out.println(s==e ? -1 : q.get(e-1));
                        break;
                    case "pop":
                        System.out.println(s==e ? -1 : q.get(s++));
                        break;
                    case "empty":
                        System.out.println(s==e ? 1 : 0);
                        break;
                    default:
                        System.out.println(e-s);
                }
            }
        }
    }
}
