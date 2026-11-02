import java.util.Scanner;

public class Task22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] m = new int[3][3];
        System.out.println("Enter the 3x3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m[i][j] = sc.nextInt();
            }
        }
        boolean symmetric = true;
        System.out.println("Transpose:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(m[j][i] + " ");
                if (m[i][j] != m[j][i]) {
                    symmetric = false;
                }
            }
            System.out.println();
        }
        System.out.println(symmetric ? "The matrix is symmetric." : "The matrix is not symmetric.");
    }
}
