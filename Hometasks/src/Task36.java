import java.util.Arrays;
import java.util.Scanner;

public class Task36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        int[] last = new int[65536];
        Arrays.fill(last, -1);
        int start = 0, bestStart = 0, bestLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (last[ch] >= start) {
                start = last[ch] + 1;
            }
            last[ch] = i;
            if (i - start + 1 > bestLen) {
                bestLen = i - start + 1;
                bestStart = start;
            }
        }
        System.out.println("Substring: " + s.substring(bestStart, bestStart + bestLen));
        System.out.println("Length: " + bestLen);
    }
}
