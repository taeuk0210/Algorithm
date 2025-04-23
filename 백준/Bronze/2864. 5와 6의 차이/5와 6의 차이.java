import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] n = sc.nextLine().split(" ");
        System.out.println(
            (Integer.parseInt(n[0].replace("6", "5"))+
             Integer.parseInt(n[1].replace("6", "5"))) + 
            " " + 
            (Integer.parseInt(n[0].replace("5", "6"))+
             Integer.parseInt(n[1].replace("5", "6"))));
        
    }
}