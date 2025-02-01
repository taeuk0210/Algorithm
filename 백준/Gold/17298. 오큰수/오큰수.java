import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[N];
        answer[N-1] = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i=N-2; i>=0; i--) {
            if (A[i] < A[i + 1]) {
                stack.push(A[i + 1]);
                answer[i] = stack.peek();
            } else {
                while (!stack.isEmpty() && stack.peek() <= A[i]) stack.pop();
                answer[i] = stack.isEmpty() ? -1 : stack.peek();
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int a : answer) sb.append(a).append(" ");
        System.out.println(sb);
/*
8
12 3 1 0 2 4 10 2
*/
    }
}
