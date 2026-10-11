import java.util.Scanner;

public class Task19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array size: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            boolean duplicate = false;
            for (int j = 0; j < k; j++) {
                if (a[j] == a[i]) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                a[k++] = a[i];
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
