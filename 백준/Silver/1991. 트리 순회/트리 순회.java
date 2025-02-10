import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        tree = new int[N][2];
        for (int[] row : tree) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < N; i++) {
            char[] node = sc.nextLine().toCharArray();
            int current = node[0] - 'A';
            int left = node[2] - 'A';
            int right = node[4] - 'A';
            if (0<=left && left<=25) {
                tree[current][0] = left;
            }
            if (0<=right && right<=25) {
                tree[current][1] = right;
            }
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);

    }

    public static void preOrder(int node) {
        System.out.print((char)(node+'A'));
        if (tree[node][0] != -1) {
            preOrder(tree[node][0]);
        }
        if (tree[node][1] != -1) {
            preOrder(tree[node][1]);
        }
    }

    public static void inOrder(int node) {
        if (tree[node][0] != -1) {
            inOrder(tree[node][0]);
        }
        System.out.print((char)(node+'A'));
        if (tree[node][1] != -1) {
            inOrder(tree[node][1]);
        }
    }

    public static void postOrder(int node) {
        if (tree[node][0] != -1) {
            postOrder(tree[node][0]);
        }
        if (tree[node][1] != -1) {
            postOrder(tree[node][1]);
        }
        System.out.print((char)(node+'A'));
    }
}

