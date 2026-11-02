import java.util.Scanner;

public class Task33 {
    static void permute(String prefix, String rest) {
        if (rest.isEmpty()) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < rest.length(); i++) {
            permute(prefix + rest.charAt(i), rest.substring(0, i) + rest.substring(i + 1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with distinct characters: ");
        permute("", sc.nextLine());
    }
}
