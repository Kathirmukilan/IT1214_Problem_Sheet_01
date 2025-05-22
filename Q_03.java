class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance-=amount;
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }

    public void printDetails(){
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : " + balance);
    }
}

class Bank {
    private BankAccount[] accounts = new BankAccount[5];
    private int accountCount = 0;

    public void addAccount(BankAccount account) {
        if (accountCount < 5) {
            accounts[accountCount] = account;
            accountCount++;
        } else {
            System.out.println("Bank is reached its maximum. Cannot add more accounts.");
        }
    }

    public void withdraw(int accNumber, double amount) {
        boolean found = false;
        for (int i=0; i<accountCount; i++) {
            if (accounts[i].getAccountNumber() == accNumber) {
                try {
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawn " + amount + " from account " + accNumber);
					System.out.println();
                } catch (IllegalArgumentException e) {
                    System.out.println("Error : " + e.getMessage());
					System.out.println();
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Account " + accNumber + " not found.");
        }
    }

    public void displayAccounts() {
        System.out.println("------ Bank Accounts ------");
        for (int i=0; i<accountCount; i++) {
            accounts[i].printDetails();
            System.out.println("----------------------------");
			System.out.println();
        }
    }
}

public class Q_03 {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addAccount(new BankAccount(1001,"Alice",5000.0));
        bank.addAccount(new BankAccount(1002,"Bob",3000.0));

        bank.withdraw(1001,6000.0); 
        bank.withdraw(1002,1000.0); 

        bank.displayAccounts();
    }
}
