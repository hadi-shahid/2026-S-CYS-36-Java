import java.util.Scanner;

public class Task21 {
    static int multiplications = 0;

    static long power(long x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        long half = power(x, n / 2);
        long result = half * half;
        multiplications++;
        if (n % 2 == 1) {
            result *= x;
            multiplications++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x: ");
        long x = sc.nextLong();
        long result = power(x, 30);
        System.out.println(x + "^30 = " + result);
        System.out.println("Multiplications performed: " + multiplications);
    }
}
