import java.util.Scanner;

public class Task15 {
    static void reverse(int[] a, int i, int j) {
        while (i < j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array size: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.print("Rotate left by k: ");
        int k = sc.nextInt();
        if (n > 0) {
            k = ((k % n) + n) % n;
            reverse(a, 0, k - 1);
            reverse(a, k, n - 1);
            reverse(a, 0, n - 1);
        }
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
