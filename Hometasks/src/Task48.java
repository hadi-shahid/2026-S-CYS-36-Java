public class Task48 {
    static boolean isValid(int[][] g) {
        int[] rows = new int[9], cols = new int[9], boxes = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int v = g[i][j];
                if (v == 0) {
                    continue;
                }
                if (v < 1 || v > 9) {
                    return false;
                }
                int bit = 1 << v;
                int b = (i / 3) * 3 + j / 3;
                if ((rows[i] & bit) != 0 || (cols[j] & bit) != 0 || (boxes[b] & bit) != 0) {
                    return false;
                }
                rows[i] |= bit;
                cols[j] |= bit;
                boxes[b] |= bit;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        System.out.println("Original grid valid: " + isValid(grid));
        grid[0][0] = 3;
        System.out.println("After changing the first cell to 3, valid: " + isValid(grid));
    }
}
