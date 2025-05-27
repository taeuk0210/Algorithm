import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            String word = br.readLine();
            if (word.length() < m) continue;
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        List<String> answer = new ArrayList<>(map.keySet());
        answer.sort((a,b) -> compareWord(a, b, map));
        StringBuilder sb = new StringBuilder();
        for (String ans: answer) {
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    private static int compareWord(String a, String b, Map<String, Integer> map) {
        int valA = map.get(a);
        int valB = map.get(b);
        int lenA = a.length();
        int lenB = b.length();
        return valA != valB ? valB - valA : (
               lenA != lenB ? lenB - lenA : (
                              a.compareTo(b)));
               
    }
}