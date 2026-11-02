import java.util.Scanner;

public class Task23 {
    static String binaryLoop(long n) {
        if (n == 0) {
            return "0";
        }
        String s = "";
        while (n > 0) {
            s = (n % 2) + s;
            n /= 2;
        }
        return s;
    }

    static String binaryRecursive(long n) {
        if (n < 2) {
            return "" + n;
        }
        return binaryRecursive(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        long n = sc.nextLong();
        String sign = n < 0 ? "-" : "";
        n = Math.abs(n);
        System.out.println("Loop:      " + sign + binaryLoop(n));
        System.out.println("Recursion: " + sign + binaryRecursive(n));
    }
}
