import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j=0; j < str.length(); j++) {
                char key = str.charAt(j);
                int d = (int) Math.pow(10, str.length()-j-1);
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + d);
                } else {
                    map.put(key, d);
                }
            }
        }
        List<Integer> values = new ArrayList<>();
        for (char key: map.keySet()) {
            values.add(map.get(key));
        }
        values.sort(Collections.reverseOrder());
        int answer = 0;
        int d = 9;
        for (int v: values) {
            answer += v*(d--);
        }
        System.out.println(answer);
    }
}
