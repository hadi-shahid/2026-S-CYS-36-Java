import java.util.Scanner;

class DayType {
    private String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private int index;

    public DayType(String day) {
        setDay(day);
    }

    public void setDay(String day) {
        for (int i = 0; i < 7; i++) {
            if (days[i].equalsIgnoreCase(day)) {
                index = i;
                return;
            }
        }
        System.out.println("Invalid day!");
    }

    public void printDay() {
        System.out.println("Day: " + days[index]);
    }

    public String getDay() {
        return days[index];
    }

    public String nextDay() {
        return days[(index + 1) % 7];
    }

    public String previousDay() {
        return days[(index + 6) % 7];
    }

    public String addDays(int n) {
        return days[(index + n) % 7];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter day (Sun, Mon, Tue, Wed, Thu, Fri, Sat): ");
        DayType d = new DayType(sc.next());

        int choice;
        do {
            System.out.println("\n1. Set the day");
            System.out.println("2. Print the day");
            System.out.println("3. Return the day");
            System.out.println("4. Return the next day");
            System.out.println("5. Return the previous day");
            System.out.println("6. Add days to the current day");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter new day: ");
                    d.setDay(sc.next());
                    break;
                case 2:
                    d.printDay();
                    break;
                case 3:
                    System.out.println("Day: " + d.getDay());
                    break;
                case 4:
                    System.out.println("Next day: " + d.nextDay());
                    break;
                case 5:
                    System.out.println("Previous day: " + d.previousDay());
                    break;
                case 6:
                    System.out.print("Enter number of days to add: ");
                    int n = sc.nextInt();
                    System.out.println("Day after adding " + n + " days: " + d.addDays(n));
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}