import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter some integers: ");
        long n = sc.nextLong();
        if (n < 0) {
            n = -n;
        }
        if (n == 0) {
            System.out.print(0);
        }
        while (n > 0) {
            System.out.print(n % 10);
            n /= 10;
        }
        System.out.println();
    }
}
