
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, sum = 0, count=0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            n = sc.nextInt();
            sum += n;
            map.put(n, map.getOrDefault(n, 1) + 1);
            if (count < map.get(n)) {
                count = map.get(n);
            }
            list.add(n);
        }
        Collections.sort(list);
        final int cnt = count;
        int[] keys = map.keySet().stream()
                .filter(x -> map.get(x)==cnt)
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Math.round((double)sum/list.size()));
        System.out.println(list.get(list.size()/2));
        System.out.println(keys.length>1 ? keys[1] : keys[0]);
        System.out.println(list.get(list.size()-1) - list.get(0));

    }
}
