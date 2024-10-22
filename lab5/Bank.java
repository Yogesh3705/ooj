import java.util.Scanner;

// Base class representing a general bank account
class Account {
    String customerName;
    String accountNumber;
    double balance;
    String accountType;

    // Constructor to initialize customer details
    Account(String customerName, String accountNumber, double balance, String accountType) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    // Method to display balance
    void displayBalance() {
        System.out.println("Account Holder: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    // Method to accept deposit
    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited: " + amount);
        System.out.println("Updated Balance: " + balance);
    }

    // Method for withdrawal (to be overridden by subclasses)
    void withdraw(double amount) {
        // To be implemented in the specific account type classes
    }
}

// Class for Savings Account that derives from Account
class SavAcct extends Account {
    private final double interestRate = 0.05; // 5% annual interest rate

    // Constructor for SavAcct
    SavAcct(String customerName, String accountNumber, double balance) {
        super(customerName, accountNumber, balance, "Savings");
    }

    // Method to compute and deposit interest
    void computeAndDepositInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest of " + interestRate * 100 + "% applied.");
        System.out.println("Interest Amount: " + interest);
        System.out.println("Updated Balance: " + balance);
    }

    // Override withdrawal method (no minimum balance required)
    @Override
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal denied.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Amount: " + amount);
            System.out.println("Updated Balance: " + balance);
        }
    }
}

// Class for Current Account that derives from Account
class CurAcct extends Account {
    private final double minBalance = 500.0; // Minimum balance required
    private final double serviceCharge = 50.0; // Service charge if balance falls below minimum

    // Constructor for CurAcct
    CurAcct(String customerName, String accountNumber, double balance) {
        super(customerName, accountNumber, balance, "Current");
    }

    // Override withdrawal method with penalty for falling below minimum balance
    @Override
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal denied.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Amount: " + amount);
            if (balance < minBalance) {
                balance -= serviceCharge;
                System.out.println("Minimum balance not maintained. Service charge of " + serviceCharge + " imposed.");
            }
            System.out.println("Updated Balance: " + balance);
        }
    }
}

// Main class to test the bank account system
public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Bank Account Management System!");

        // Get user input for account type
        System.out.print("Enter Account Type (Savings/Current): ");
        String accountType = sc.nextLine().toLowerCase();

        // Get common customer details
        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();
        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        Account account;

        // Create either a Savings or Current account based on input
        if (accountType.equals("savings")) {
            account = new SavAcct(customerName, accountNumber, initialBalance);
        } else if (accountType.equals("current")) {
            account = new CurAcct(customerName, accountNumber, initialBalance);
        } else {
            System.out.println("Invalid account type entered.");
            return;
        }

        // Menu to perform operations
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (account instanceof SavAcct) {
                System.out.println("4. Compute Interest (Savings only)");
            }
            System.out.println("5. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = sc.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    if (account instanceof SavAcct) {
                        ((SavAcct) account).computeAndDepositInterest();
                    } else {
                        System.out.println("Interest computation is only available for Savings accounts.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using the Bank Account Management System!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

