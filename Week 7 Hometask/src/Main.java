import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    private String name;
    private String CNIC;
    private String phoneNo;

    public Person(String name, String CNIC, String phoneNo) {
        this.name = name;
        this.CNIC = CNIC;
        this.phoneNo = phoneNo;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCNIC() { return CNIC; }
    public void setCNIC(String CNIC) { this.CNIC = CNIC; }
    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public String toString() {
        return "Name: " + name + ", CNIC: " + CNIC + ", Phone: " + phoneNo;
    }
}

class Account {
    private String number;
    private float amount;
    private Client ACholder;
    static int count = 0;

    public Account(String number, float amount, Client ACholder) {
        this.number = number;
        this.amount = amount;
        this.ACholder = ACholder;
        count++;
    }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount; }
    public Client getACholder() { return ACholder; }
    public void setACholder(Client ACholder) { this.ACholder = ACholder; }

    // returns the remaining amount in account
    public float withdraw(float amt) {
        if (amt <= amount) {
            amount = amount - amt;
        } else {
            System.out.println("Not enough balance");
        }
        return amount;
    }

    // returns the current amount in account
    public float deposit(float amt) {
        amount = amount + amt;
        return amount;
    }

    public String toString() {
        return "Account No: " + number + ", Amount: " + amount
                + ", Holder: " + ACholder.getPersonDetails().getName();
    }
}

class Client {
    private String Id;
    private Person PersonDetails;
    private List<Account> AcList = new ArrayList<>();
    static int count = 0;

    public Client(Person personDetails) {
        count++;
        this.Id = "C" + count;
        this.PersonDetails = personDetails;
    }

    public String getId() { return Id; }
    public void setId(String id) { this.Id = id; }
    public Person getPersonDetails() { return PersonDetails; }
    public void setPersonDetails(Person p) { this.PersonDetails = p; }
    public List<Account> getAcList() { return AcList; }
    public void setAcList(List<Account> acList) { this.AcList = acList; }

    // total amount in all accounts of this client
    public float totalAmount() {
        float total = 0;
        for (Account a : AcList) {
            total = total + a.getAmount();
        }
        return total;
    }

    public void withdraw(float amount, String accNo) {
        for (Account a : AcList) {
            if (a.getNumber().equals(accNo)) {
                System.out.println("Remaining amount: " + a.withdraw(amount));
                return;
            }
        }
        System.out.println("Account not found");
    }

    public void deposit(float amount, String accNo) {
        for (Account a : AcList) {
            if (a.getNumber().equals(accNo)) {
                System.out.println("Current amount: " + a.deposit(amount));
                return;
            }
        }
        System.out.println("Account not found");
    }

    public void addAccount(Account a) {
        AcList.add(a);
    }

    public String toString() {
        String s = "Client Id: " + Id + "\n" + PersonDetails + "\n";
        for (Account a : AcList) {
            s = s + "  Account Id: " + a.getNumber() + ", Amount: " + a.getAmount() + "\n";
        }
        return s;
    }
}

class Bank {
    private String name;
    private List<Client> CIList = new ArrayList<>();
    private List<Account> AcList = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Client> getCIList() { return CIList; }
    public void setCIList(List<Client> CIList) { this.CIList = CIList; }
    public List<Account> getAcList() { return AcList; }
    public void setAcList(List<Account> acList) { this.AcList = acList; }

    public Client addClient(Person p) {
        Client c = new Client(p);
        CIList.add(c);
        return c;
    }

    public Account addAccount(String id, float amount, Client c) {
        Account a = new Account(id, amount, c);
        AcList.add(a);
        c.addAccount(a);
        return a;
    }

    public Account searchAccount(String id) {
        for (Account a : AcList) {
            if (a.getNumber().equals(id)) {
                return a;
            }
        }
        return null;
    }

    // removes client and all of his accounts from the bank
    public Boolean removeClient(String id) {
        for (Client c : CIList) {
            if (c.getId().equals(id)) {
                AcList.removeAll(c.getAcList());
                CIList.remove(c);
                return true;
            }
        }
        return false;
    }

    public float totalAmount() {
        float total = 0;
        for (Account a : AcList) {
            total = total + a.getAmount();
        }
        return total;
    }

    public Client searchCustomerDetail(String CNIC) {
        for (Client c : CIList) {
            if (c.getPersonDetails().getCNIC().equals(CNIC)) {
                return c;
            }
        }
        return null;
    }
}

public class Main {
    static Client findClient(Bank bank, String id) {
        for (Client c : bank.getCIList()) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter bank name: ");
        Bank bank = new Bank(sc.nextLine());

        int choice;
        do {
            System.out.println("\n1. Add Client");
            System.out.println("2. Add Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Search Account");
            System.out.println("6. Search Client by CNIC");
            System.out.println("7. Total amount of a Client");
            System.out.println("8. Total amount of Bank");
            System.out.println("9. Remove Client");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("CNIC: ");
                String cnic = sc.nextLine();
                System.out.print("Phone No: ");
                String phone = sc.nextLine();
                Client c = bank.addClient(new Person(name, cnic, phone));
                System.out.println("Client added. Id = " + c.getId());

            } else if (choice == 2) {
                System.out.print("Client Id: ");
                Client c = findClient(bank, sc.nextLine());
                if (c == null) {
                    System.out.println("Client not found");
                } else {
                    System.out.print("Account number: ");
                    String no = sc.nextLine();
                    System.out.print("Amount: ");
                    float amt = Float.parseFloat(sc.nextLine());
                    bank.addAccount(no, amt, c);
                    System.out.println("Account added");
                }

            } else if (choice == 3 || choice == 4) {
                System.out.print("Client Id: ");
                Client c = findClient(bank, sc.nextLine());
                if (c == null) {
                    System.out.println("Client not found");
                } else {
                    System.out.print("Account number: ");
                    String no = sc.nextLine();
                    System.out.print("Amount: ");
                    float amt = Float.parseFloat(sc.nextLine());
                    if (choice == 3) {
                        c.deposit(amt, no);
                    } else {
                        c.withdraw(amt, no);
                    }
                }

            } else if (choice == 5) {
                System.out.print("Account number: ");
                Account a = bank.searchAccount(sc.nextLine());
                System.out.println(a == null ? "Account not found" : a.toString());

            } else if (choice == 6) {
                System.out.print("CNIC: ");
                Client c = bank.searchCustomerDetail(sc.nextLine());
                System.out.println(c == null ? "Client not found" : c.toString());

            } else if (choice == 7) {
                System.out.print("Client Id: ");
                Client c = findClient(bank, sc.nextLine());
                if (c == null) {
                    System.out.println("Client not found");
                } else {
                    System.out.println("Total amount: " + c.totalAmount());
                }

            } else if (choice == 8) {
                System.out.println("Total amount in bank: " + bank.totalAmount());

            } else if (choice == 9) {
                System.out.print("Client Id: ");
                System.out.println("Removed: " + bank.removeClient(sc.nextLine()));
            }
        } while (choice != 0);

        sc.close();
    }
}