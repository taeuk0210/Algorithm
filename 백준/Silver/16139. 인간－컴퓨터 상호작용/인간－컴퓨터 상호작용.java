import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[26][str.length()];
        for (int j=0; j<str.length(); j++) {
            for (int i=0; i<26; i++) {
                if (j > 0) arr[i][j] = arr[i][j-1];
            }
            arr[(int) str.charAt(j) - 'a'][j]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = (int)st.nextToken().charAt(0) - 'a';
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0) sb.append(arr[c][b]).append("\n");
            else sb.append(arr[c][b] - arr[c][a-1]).append("\n");
        }
        System.out.println(sb);
    }

}