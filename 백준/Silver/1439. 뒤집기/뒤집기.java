import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int answer = 0;
        char last = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != last) {
                answer++;
                last = str.charAt(i);
            }
        }
        System.out.println(answer%2==0 ? answer/2 : answer/2+1);
    }
}