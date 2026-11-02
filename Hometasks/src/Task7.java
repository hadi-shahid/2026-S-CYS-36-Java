import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter multiple numbers : ");
        long n = Math.abs(sc.nextLong());
        System.out.print(n);
        while (n > 9) {
            long sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
            System.out.print(" -> " + n);
        }
        System.out.println();
    }
}
