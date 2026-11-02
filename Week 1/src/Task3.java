import java.util.Scanner;
public class Task3 {
    static void main() {
        Scanner sc = new Scanner((System.in));
        System.out.print("Enter The Time(in minutes) : ");
        int total_minutes = sc.nextInt();
        int hours = (total_minutes/60);
        int remaining_minutes = total_minutes%60;
        int remaining_mins = 12 * 60 * total_minutes;
        //remaining_mins = hours%24;
        //remaining_mins = hours%12;
        System.out.print ((hours+12)+":" + remaining_minutes);

    }
}
