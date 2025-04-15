import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()); 
                arr[i][0] = Integer.parseInt(st.nextToken()); 
                arr[i][1] = Integer.parseInt(st.nextToken()); 
            }


            Arrays.sort(arr, Comparator.comparing(a -> a[0]));
            int answer = 1;
            int best = arr[0][1];
            for (int i=1; i<N; i++) {
                if (arr[i][1] < best) {
                    answer++;
                    best = arr[i][1];
                }
            }
            System.out.println(answer);
        }
    }
}