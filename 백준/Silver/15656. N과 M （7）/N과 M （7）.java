import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        rec(0, new int[m]);
        System.out.print(sb);
    }
    public static void rec(int index, int[] input) {
        if (index == m) {
            sb.append(Arrays.toString(input).replaceAll("[\\[\\],]",""))
                    .append("\n");
            return;
        }
        
        for (int i=0; i<n; i++) {
            input[index] = nums[i];
            rec(index+1, input);
            input[index] = 0;
        }
        
    }
    
}
