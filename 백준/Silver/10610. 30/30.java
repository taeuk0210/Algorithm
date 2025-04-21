import java.util.*;
import java.io.*;
/*

*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Map<Character, Integer> count = new HashMap<>();
        for (int i=0; i<10; i++) {
            count.put(String.valueOf(i).charAt(0), 0);
        }
        int digitSum = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            count.put(c, count.get(c) + 1);
            digitSum += c - '0';
        }
        if (!(count.get('0') > 0 && digitSum % 3 == 0)) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i=9; i>=0; i--) {
                char key = String.valueOf(i).charAt(0);
                int v = count.get(key);
                for (int j=0; j<v; j++) {
                    sb.append(key);
                }
            }
            System.out.println(sb.toString());
        }
    }
}