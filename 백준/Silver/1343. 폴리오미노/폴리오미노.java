import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        String answer = "";
        int count=0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '.') {
                int nA = count / 4;
                count %= 4;
                int nB = count / 2;
                count %= 2;
                if (count != 0) {
                    answer = "-1";
                    break;
                } else {
                    for (int j=0; j<nA; j++) {
                        answer += "AAAA";
                    }
                    for (int j=0; j<nB; j++) {
                        answer += "BB";
                    }
                    answer += ".";
                }
            } else {
                count++;
            }
        }
        int nA = count / 4;
        count %= 4;
        int nB = count / 2;
        count %= 2;
        if (count != 0) {
            answer = "-1";
        } else {
            for (int j=0; j<nA; j++) {
                answer += "AAAA";
            }
            for (int j=0; j<nB; j++) {
                answer += "BB";
            }
        }
        
        System.out.println(answer);
    }
}