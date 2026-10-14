import java.util.Scanner;

interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

class Bank implements BankAccount {
    private double balance;

    Bank(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount!");
        }
        balance += amount;
        System.out.println("Amount deposited successfully.");
        System.out.println("Current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount!");
        }
        if (amount > balance) {
            throw new ArithmeticException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Amount withdrawn successfully.");
        System.out.println("Current balance: " + balance);
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}

public class EX6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank(1000);

        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double deposit = sc.nextDouble();
                        bank.deposit(deposit);
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdraw = sc.nextDouble();
                        bank.withdraw(withdraw);
                        break;

                    case 3:
                        bank.checkBalance();
                        break;

                    case 4:
                        System.out.println("Thank you!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
            }
        }
    }
}
