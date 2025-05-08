import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] age = new int[n];
        Integer[] idx = new Integer[n];
        String[] name = new String[n];
        for (int i=0; i<n; i++) {
            String[] a = sc.nextLine().split(" ");
            age[i] = Integer.parseInt(a[0]);
            name[i] = a[1];
            idx[i] = i;
        }
        Arrays.sort(idx, (i,j)-> age[i]!=age[j] ? age[i]-age[j] : i-j);
        for (int i=0; i<n; i++) {
            System.out.println(age[idx[i]] + " " + name[idx[i]]);
        }
    }
}