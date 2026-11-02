import java.util.Scanner;

public class Task31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        int[][] p = new int[n][];
        for (int i = 0; i < n; i++) {
            p[i] = new int[i + 1];
            p[i][0] = p[i][i] = 1;
            for (int j = 1; j < i; j++) {
                p[i][j] = p[i - 1][j - 1] + p[i - 1][j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(" ".repeat(2 * (n - 1 - i)));
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", p[i][j]);
            }
            System.out.println();
        }
    }
}
