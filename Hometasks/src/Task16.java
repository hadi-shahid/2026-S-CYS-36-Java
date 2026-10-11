import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an odd n: ");
        int n = sc.nextInt();
        if (n < 1 || n % 2 == 0) {
            System.out.println("n must be a positive odd number.");
            return;
        }
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            int left = Math.abs(mid - i);
            int right = n - 1 - left;
            for (int j = 0; j <= right; j++) {
                System.out.print(j == left || j == right ? "*" : " ");
            }
            System.out.println();
        }
    }
}
