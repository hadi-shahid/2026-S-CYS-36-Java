import java.util.Scanner;

public class Task25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        int[] count = new int[65536];
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }
        for (char ch : s.toCharArray()) {
            if (count[ch] == 1) {
                System.out.println("First non-repeating character: " + ch);
                return;
            }
        }
        System.out.println("none");
    }
}
