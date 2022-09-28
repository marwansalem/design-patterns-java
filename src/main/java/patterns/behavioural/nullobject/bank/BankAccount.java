package patterns.behavioural.nullobject.bank;

public class BankAccount {
    private Log log;

    public int getBalance() {
        return balance;
    }

    private int balance;
    public BankAccount(Log log) {
        this.log = log;
    }

    public void deposit(int amount) {
        balance += amount;
        log.info("Deposited " + amount);
    }
}
