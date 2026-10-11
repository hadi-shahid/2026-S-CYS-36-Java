import java.util.Scanner;

public class Task18 {
    static boolean areAnagrams(String a, String b) {
        int[] count = new int[65536];
        for (char ch : a.toLowerCase().toCharArray()) {
            if (ch != ' ') {
                count[ch]++;
            }
        }
        for (char ch : b.toLowerCase().toCharArray()) {
            if (ch != ' ') {
                count[ch]--;
            }
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("First string: ");
        String a = sc.nextLine();
        System.out.print("Second string: ");
        String b = sc.nextLine();
        System.out.println(areAnagrams(a, b) ? "Anagrams" : "Not anagrams");
    }
}
