import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i=0; i<n;i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, (a,b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        
        for (int[] a: arr) {
            System.out.println(a[0] + " " + a[1]);
        }
    }
}