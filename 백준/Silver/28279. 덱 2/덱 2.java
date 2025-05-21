import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = Integer.parseInt(sc.nextLine());
        Deque<Integer> d = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            String str = sc.nextLine();
            if (str.startsWith("1")) {
                d.offerFirst(Integer.parseInt(str.split(" ")[1]));
                continue;
            } else if (str.startsWith("2")) {
                d.offerLast(Integer.parseInt(str.split(" ")[1]));
                continue;
            }
            switch (Integer.parseInt(str)) {
                case 3:
                    sb.append(d.isEmpty() ? -1 : d.pollFirst()).append("\n");
                    break;
                case 4:
                    sb.append(d.isEmpty() ? -1 : d.pollLast()).append("\n");
                    break;
                case 5:
                    sb.append(d.size()).append("\n");
                    break;
                case 6:
                    sb.append(d.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 7:
                    sb.append(d.isEmpty() ? -1 : d.peekFirst()).append("\n");
                    break;
                case 8:
                    sb.append(d.isEmpty() ? -1 : d.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}