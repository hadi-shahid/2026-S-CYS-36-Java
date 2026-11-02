import java.util.Scanner;

public class Task40 {
    static int moves = 0;

    static void hanoi(int n, char from, char to, char via) {
        if (n == 0) {
            return;
        }
        hanoi(n - 1, from, via, to);
        moves++;
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        hanoi(n - 1, via, to, from);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();
        hanoi(n, 'A', 'C', 'B');
        long expected = (1L << n) - 1;
        System.out.println("Total moves: " + moves + ", 2^n - 1 = " + expected
                + (moves == expected ? " (verified)" : " (mismatch)"));
    }
}
