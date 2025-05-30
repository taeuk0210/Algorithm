import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str1 = sc.nextLine();
        
        boolean[] isCorrect = new boolean[str1.length()];
        Arrays.fill(isCorrect, true);
        for (int i=1; i<n; i++) {
            String str2 = sc.nextLine();
            for (int j=0; j<str2.length(); j++) {
                if(isCorrect[j]){
                isCorrect[j] = str1.charAt(j) == str2.charAt(j);
            }}
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<str1.length(); i++) {
            sb.append(isCorrect[i] ? str1.charAt(i) : '?');
        }
        System.out.print(sb);
        
    }
}