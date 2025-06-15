import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input.equals("0")) break;
            
            String[] str = input.split(" ");
            n = Integer.parseInt(str[0]);
            arr = new int[n];
            for (int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(str[i+1]);
            }
            
            backtrack(0, 0, new int[6]);
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
    
    private static void backtrack(int depth, int start, int[] current) {
        if (depth == 6) {
            for (int i=0; i<6; i++) {
                sb.append(arr[current[i]]).append(" ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
            return;
        }
        
        for (int i=start; i<n; i++) {
            current[depth] = i;
            backtrack(depth+1, i+1, current);
        }
    }
}