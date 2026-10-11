import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        int vowels = 0, consonants = 0, digits = 0, others = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if ("aeiou".indexOf(ch) >= 0) {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            } else if (ch >= '0' && ch <= '9') {
                digits++;
            } else {
                others++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Other characters: " + others);
    }
}
