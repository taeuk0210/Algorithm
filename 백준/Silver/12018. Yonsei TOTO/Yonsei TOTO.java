import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] costs = new int[n];

        for (int i=0; i<n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();
            int[] arr = new int[p];
            for (int j=0; j<p; j++) {
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            if (l > p) {
                costs[i] = 1;
            } else {
                costs[i] = arr[p-l];
            }
        }        
        Arrays.sort(costs);
        int answer = 0;
        for (int cost: costs) {
            if (m >= cost) {
                answer++;
                m -= cost;
            }
        }
        System.out.println(answer);
    }
}