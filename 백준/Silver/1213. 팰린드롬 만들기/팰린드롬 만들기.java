import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey((int) str.charAt(i))) {
                map.put((int) str.charAt(i), map.get((int) str.charAt(i)) + 1);
            } else {
                map.put((int) str.charAt(i), 1);
            }
        }
        int numOdds = 0;
        for (int key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                numOdds++;
            }
        }

        if (numOdds > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            List<Integer> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys);
            Stack<Integer> stack = new Stack<>();
            int odd = -1;
            StringBuilder answer = new StringBuilder();
            for (int key : keys) {
                if (map.get(key) % 2 == 1) {
                    odd = key;
                }
                stack.push(key);
                for (int i=0; i<map.get(key)/2; i++) {
                    answer.append((char)key);
                }
            }
            if (odd != -1) {
                answer.append((char)odd);
            }
            while (!stack.isEmpty()) {
                int key = stack.pop();
                for (int i=0; i<map.get(key)/2; i++) {
                    answer.append((char)key);
                }
            }
            System.out.println(answer.toString());
        }
    }
}
