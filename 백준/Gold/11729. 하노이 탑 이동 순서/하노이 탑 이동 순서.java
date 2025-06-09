import java.util.*;

public class Main {
    static List<int[]> moves = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        hanoi(n, 1, 2, 3);
        StringBuilder sb = new StringBuilder();
        sb.append(moves.size()).append("\n");
        for (int[] move: moves) {
            sb.append(move[0]).append(" ").append(move[1]).append("\n");
        }
        System.out.print(sb);
        
    }
    
    private static void hanoi(int n, int s, int a, int d) {
        if (n == 1) {
            moves.add(new int[] {s, d});
        } else {
            hanoi(n-1, s, d, a);
            hanoi(1, s, a, d);
            hanoi(n-1, a, s, d);
        }
    }
}