import java.util.Scanner;

public class Task35 {
    static int[] binarySearch(int[] a, int key) {
        int lo = 0, hi = a.length - 1, steps = 0;
        while (lo <= hi) {
            steps++;
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) {
                return new int[]{mid, steps};
            }
            if (a[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return new int[]{-1, steps};
    }

    static int[] firstOccurrence(int[] a, int key) {
        int lo = 0, hi = a.length - 1, steps = 0, result = -1;
        while (lo <= hi) {
            steps++;
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) {
                result = mid;
                hi = mid - 1;
            } else if (a[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return new int[]{result, steps};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sorted = {1, 3, 5, 7, 9, 11, 13};
        int[] withDuplicates = {1, 2, 2, 2, 2, 3, 5, 8};
        System.out.print("Enter the key to search: ");
        int key = sc.nextInt();
        int[] r1 = binarySearch(sorted, key);
        int[] r2 = firstOccurrence(withDuplicates, key);
        System.out.println("Binary search in {1,3,5,7,9,11,13}: index " + r1[0] + ", steps " + r1[1]);
        System.out.println("First occurrence in {1,2,2,2,2,3,5,8}: index " + r2[0] + ", steps " + r2[1]);
    }
}
