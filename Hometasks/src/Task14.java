import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        System.out.print("Enter 10 integers: ");
        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
        }
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE;
        for (int x : a) {
            if (x > first) {
                second = first;
                first = x;
            } else if (x < first && x > second) {
                second = x;
            }
        }
        if (second == Long.MIN_VALUE) {
            System.out.println("No second largest value (all elements are equal).");
        } else {
            System.out.println("Second largest: " + second);
        }
    }
}
