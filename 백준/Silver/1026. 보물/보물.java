import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] A = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] B = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            answer += A[i]*B[N-1-i];
        }
        System.out.print(answer);
    }
}
