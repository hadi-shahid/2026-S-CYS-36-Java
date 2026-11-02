import java.util.Scanner;

public class Task46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array size: ");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("The array is empty.");
            return;
        }
        int[] a = new int[n];
        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        long best = Long.MIN_VALUE, current = 0;
        int start = 0, bestStart = 0, bestEnd = 0;
        for (int i = 0; i < n; i++) {
            if (current <= 0) {
                current = a[i];
                start = i;
            } else {
                current += a[i];
            }
            if (current > best) {
                best = current;
                bestStart = start;
                bestEnd = i;
            }
        }
        System.out.println("Maximum sum: " + best + " (indices " + bestStart + " to " + bestEnd + ")");
    }
}
