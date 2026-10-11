import java.util.Scanner;

public class Task30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (numbers are 1 to n): ");
        int n = sc.nextInt();
        System.out.print("Enter the " + (n - 1) + " given numbers: ");
        int missing = 0;
        for (int i = 1; i <= n; i++) {
            missing ^= i;
        }
        for (int i = 0; i < n - 1; i++) {
            missing ^= sc.nextInt();
        }
        System.out.println("Missing number: " + missing);
    }
}
