import java.util.Scanner;

// Base class representing a general bank account
class Account {
    String customerName;
    String accountNumber;
    double balance;

    // Constructor to initialize customer details
    Account(String customerName, String accountNumber, double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
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
        // This will be defined in subclasses for specific account types
    }
}

// Class for savings account that derives from Account
class SavAcct extends Account {
    private final double interestRate = 0.04; // 4% annual interest rate

    // Constructor for SavAcct
    SavAcct(String customerName, String accountNumber, double balance) {
        super(customerName, accountNumber, balance);
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

// Class for current account that derives from Account
class CurAcct extends Account {
    private final double minBalance = 500.0; // Minimum balance required
    private final double serviceCharge = 50.0; // Service charge for falling below minimum balance

    // Constructor for CurAcct
    CurAcct(String customerName, String accountNumber, double balance) {
        super(customerName, accountNumber, balance);
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

        // Create Savings Account
        SavAcct savAccount = new SavAcct("Alice", "SAV12345", 1000);
        savAccount.displayBalance();
        System.out.println("\n---Deposit to Savings Account---");
        savAccount.deposit(500);
        System.out.println("\n---Withdraw from Savings Account---");
        savAccount.withdraw(200);
        System.out.println("\n---Compute and Deposit Interest in Savings Account---");
        savAccount.computeAndDepositInterest();

        // Create Current Account
        CurAcct curAccount = new CurAcct("Bob", "CUR67890", 1000);
        curAccount.displayBalance();
        System.out.println("\n---Deposit to Current Account---");
        curAccount.deposit(500);
        System.out.println("\n---Withdraw from Current Account---");
        curAccount.withdraw(1600); // This will impose service charge due to low balance
        curAccount.displayBalance();

        sc.close();
    }
}
