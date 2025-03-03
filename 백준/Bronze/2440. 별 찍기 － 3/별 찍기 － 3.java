import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String answer = "";
        for (int i=n; i>=1; i--) {
            for (int j=0; j<i; j++) {
                answer += "*";
            }
            answer += i==1 ? "" : "\n";
        }
        System.out.print(answer);
    
    }
}