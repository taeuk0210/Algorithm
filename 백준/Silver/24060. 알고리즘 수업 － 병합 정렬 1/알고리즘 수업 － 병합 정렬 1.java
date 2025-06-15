import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;
    static int answer = -1;
    static int k;
    static int[] tmp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        tmp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, arr.length-1);
        System.out.print(-1);
       
    }
    
    private static void mergeSort(int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort( l, m);
            mergeSort( m+1, r);
            merge( l, m, r);
        }
    }
    
    private static void merge(int l,int m,int r) {
        int i = l;
        int j = m + 1;
        int t = l;
        while( i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }
        while (i <= m) {
            tmp[t++] = arr[i++];
        }
        while (j <= r) {
            tmp[t++] = arr[j++];
        }
        for (int idx = l; idx <= r; idx++) {
            arr[idx] = tmp[idx];
            count++;
            if (count == k) {
                System.out.println(arr[idx]);
                System.exit(0);
            }
        }
    }
}