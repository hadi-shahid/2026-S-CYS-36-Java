import java.util.Scanner;

class StudentRecord {
    private String name;
    private String roll;
    private String[] subjects = {"Math", "Physics", "Programming", "Calculus"};
    private int[] marks = new int[subjects.length];
    private boolean[] changed = new boolean[subjects.length];

    public StudentRecord(String name, String roll) {
        this.name = name;
        this.roll = roll;
    }

    public String getName() { return name; }
    public String getRoll() { return roll; }

    public void showMarks() {
        System.out.println("  #    Subject       Marks ");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("  %-2d   %-11s   %-5d  %n", i + 1, subjects[i], marks[i]);
        }
    }

    public int subjectCount() { return subjects.length; }

    public void changeMarks(int index, int newMarks) {
        marks[index] = newMarks;
        changed[index] = true;
    }

    public boolean allChanged() {
        for (boolean c : changed) {
            if (!c) return false;
        }
        return true;
    }
}

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentRecord[] students = {
                new StudentRecord("Hadi Shahid", "2026-Cys-36"),
                new StudentRecord("Ali Khan",    "2026-Cys-37")
        };

        while (true) {
            System.out.print("\nEnter roll no (or type exit): ");
            String roll = sc.nextLine().trim();

            if (roll.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            StudentRecord found = null;
            for (StudentRecord s : students) {
                if (s.getRoll().equalsIgnoreCase(roll)) {
                    found = s;
                    break;
                }
            }

            if (found == null) {
                System.out.println("Student not found.");
                continue;
            }

            System.out.println("Student: " + found.getName());

            boolean firstTime = !found.allChanged();

            while (true) {
                found.showMarks();

                if (firstTime && found.allChanged()) {
                    System.out.println("\nAll subjects done!");
                    break;
                }

                if (firstTime) {
                    System.out.print("\nEnter subject number to change: ");
                } else {
                    System.out.print("\nEnter subject number to change (0 to go back): ");
                }

                int sub;
                try {
                    sub = Integer.parseInt(sc.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number.");
                    continue;
                }

                if (!firstTime && sub == 0) {
                    break;
                }

                if (sub < 1 || sub > found.subjectCount()) {
                    System.out.println("Invalid subject.");
                    continue;
                }

                System.out.print("Enter new marks: ");
                int newMarks;
                try {
                    newMarks = Integer.parseInt(sc.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number.");
                    continue;
                }

                found.changeMarks(sub - 1, newMarks);
                System.out.println("\nMarks updated!");
            }
        }

        sc.close();
    }
}