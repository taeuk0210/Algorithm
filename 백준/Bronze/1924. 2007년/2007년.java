import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, map.get(1) + 31);
        map.put(3, map.get(2) + 28);
        map.put(4, map.get(3) + 31);
        map.put(5, map.get(4) + 30);
        map.put(6, map.get(5) + 31);
        map.put(7, map.get(6) + 30);
        map.put(8, map.get(7) + 31);
        map.put(9, map.get(8) + 31);
        map.put(10, map.get(9) + 30);
        map.put(11, map.get(10) + 31);
        map.put(12, map.get(11) + 30);
        
        d += map.get(m);
        
        switch(d%7) {
            case 0:
                System.out.println("SUN");
                break;
            case 1:
                System.out.println("MON");
                break;
            case 2:
                System.out.println("TUE");
                break;
            case 3:
                System.out.println("WED");
                break;
            case 4:
                System.out.println("THU");
                break;
            case 5:
                System.out.println("FRI");
                break;
            case 6:
                System.out.println("SAT");
                break;
        }
    }
}