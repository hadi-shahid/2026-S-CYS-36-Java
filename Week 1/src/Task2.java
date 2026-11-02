import java.util.Scanner;
public class Task2 {
    static void main() {
        Scanner sc = new Scanner((System.in));
        System.out.print("Enter The Time(in minutes) : ");
        int minutes = sc.nextInt();
        int hours = minutes/60;
        int remaining_minutes = minutes%60;
        System.out.print (hours+":" + remaining_minutes);

    }
}
