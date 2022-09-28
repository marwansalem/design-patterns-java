package patterns.behavioural.memento.bank;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public BalanceMemento deposit(int amount) {
        balance += amount;
        return new BalanceMemento(balance);
    }

    public void restore(BalanceMemento memento) {
        this.balance = memento.getBalance();
    }

    public int getBalance() {
        return balance;
    }

    public BalanceMemento makeBackup() {
        return new BalanceMemento(balance);
    }

    @Override
    public String toString() {
        return "Account{" +
            "balance=" + balance +
            '}';
    }
}
