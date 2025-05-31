import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] op;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        op = new int[4];
        for (int i=0; i<4; i++) {
            op[i] = sc.nextInt();
        }
        backtrack(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
    
    private static void backtrack(int index, int num) {
        if (index == n) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }
        
        for (int i=0; i<4; i++) {
            if (op[i] == 0) {
                continue;
            }
            int newNum;
            switch (i) {
                case 0:
                    newNum = num + arr[index];
                    break;
                case 1:
                    newNum = num - arr[index];
                    break;
                case 2:
                    newNum = num * arr[index];
                    break;
                default:
                    newNum = num / arr[index];
            }
            
            op[i]--;
            backtrack(index + 1, newNum);
            op[i]++;
        }
        
    }
    
}