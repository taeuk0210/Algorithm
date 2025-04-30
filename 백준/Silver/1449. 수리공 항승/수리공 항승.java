import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        
        int answer = 0;
        int tapeEnd = -1;
        for (int a: arr) {
            if (a > tapeEnd) {
                answer++;
                tapeEnd = a + l - 1;
            }
        }
        System.out.println(answer);
    }
}