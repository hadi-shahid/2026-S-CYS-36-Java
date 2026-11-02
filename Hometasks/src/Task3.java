import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double middle = Math.max(Math.min(a, b), Math.min(Math.max(a, b), c));
        System.out.println("Middle number: " + middle);
    }
}
