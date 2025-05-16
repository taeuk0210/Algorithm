import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            long n = sc.nextLong(); 
            System.out.println(nextPrime(n));
        }
    }

    private static long nextPrime(long n) {
        if (n <= 2) return 2;
        while (true) {
            if (isPrime(n)) return n;
            n++;
        }
    }

    private static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        long sqrt = (long) Math.sqrt(num);
        for (long i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}
