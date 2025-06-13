import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int mask = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<m; i++) {
            String str = br.readLine();
            if (str.equals("all")) {
                mask = (1 << 21) - 1;
            } else if (str.equals("empty")) {
                mask = 0;
            } else {
                String[] op = str.split(" ");
                int n = Integer.parseInt(op[1]);
                switch(op[0]) {
                    case "add":
                        mask |= 1 << n;
                        break;
                    case "check":
                        sb.append((mask & (1 << n))!= 0 ? 1 : 0).append("\n");
                        break;
                    case "remove":
                        mask &= ~(1 << n);
                        break;
                    case "toggle":
                        mask ^= (1 << n);
                }
            }
        }
        System.out.println(sb);
    }
}