import java.util.Scanner;

public class Task2 {

    static class SavingAccount {
        private String name;
        private double balance;

        public void savingAccount(String name, double openingBalance) {
            if (openingBalance <= 0) {
                throw new IllegalArgumentException("Opening balance must be greater than 0.");
            }
            this.name = name;
            this.balance = openingBalance;
        }

        public void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid amount.");
                return;
            }
            balance += amount;
            System.out.println("Deposited " + amount);
        }

        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid amount.");
            } else if (amount > balance) {
                System.out.println("Insufficient balance.");
            } else {
                balance -= amount;
                System.out.println("Withdrawn " + amount);
            }
        }

        public void checkBalance() {
            System.out.println(name + "'s current balance: " + balance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavingAccount acc = new SavingAccount();

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        while (true) {
            System.out.print("Enter opening balance: ");
            try {
                acc.savingAccount(name, sc.nextDouble());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        int choice;
        do {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Amount: ");
                    acc.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Amount: ");
                    acc.withdraw(sc.nextDouble());
                    break;
                case 3:
                    acc.checkBalance();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
        sc.close();
    }
}