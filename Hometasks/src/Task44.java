public class Task44 {
    static final int N = 6;
    static int[] cols = new int[N];
    static int[] firstSolution = null;
    static int count = 0;

    static boolean isSafe(int row, int col) {
        for (int r = 0; r < row; r++) {
            if (cols[r] == col || Math.abs(cols[r] - col) == row - r) {
                return false;
            }
        }
        return true;
    }

    static void solve(int row) {
        if (row == N) {
            count++;
            if (firstSolution == null) {
                firstSolution = cols.clone();
            }
            return;
        }
        for (int c = 0; c < N; c++) {
            if (isSafe(row, c)) {
                cols[row] = c;
                solve(row + 1);
            }
        }
    }

    public static void main(String[] args) {
        solve(0);
        System.out.println("Total solutions for N = " + N + ": " + count);
        System.out.println("One valid board:");
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(firstSolution[r] == c ? "Q " : ". ");
            }
            System.out.println();
        }
    }
}
