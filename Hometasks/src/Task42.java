import java.util.Scanner;

public class Task42 {
    static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            result[k++] = a[i] <= b[j] ? a[i++] : b[j++];
        }
        while (i < a.length) {
            result[k++] = a[i++];
        }
        while (j < b.length) {
            result[k++] = b[j++];
        }
        return result;
    }

    static int[] readSorted(Scanner sc, String name) {
        System.out.print("Size of " + name + ": ");
        int[] a = new int[sc.nextInt()];
        System.out.print("Enter " + a.length + " sorted elements: ");
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] merged = merge(readSorted(sc, "first array"), readSorted(sc, "second array"));
        System.out.print("Merged: ");
        for (int x : merged) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
