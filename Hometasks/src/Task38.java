import java.util.Scanner;

public class Task38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Rows and columns: ");
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] a = new int[n][m];
        System.out.println("Enter the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int top = 0, bottom = n - 1, left = 0, right = m - 1;
        System.out.print("Spiral order: ");
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                System.out.print(a[top][j] + " ");
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.print(a[i][right] + " ");
            }
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    System.out.print(a[bottom][j] + " ");
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(a[i][left] + " ");
                }
                left++;
            }
        }
        System.out.println();
    }
}
