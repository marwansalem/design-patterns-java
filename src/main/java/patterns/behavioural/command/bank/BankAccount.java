package patterns.behavioural.command.bank;

public class BankAccount {
    private int balance;
    private int overdraftLimit = -500;

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ", balance is now " + balance);
    }

    public BankAccount() {
    }

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean withdraw(int amount) {
        if (balance - amount >= overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ", balance is now " + balance);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
            "balance=" + balance +
            '}';
    }
}
