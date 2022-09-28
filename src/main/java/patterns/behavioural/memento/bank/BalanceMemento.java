package patterns.behavioural.memento.bank;

public class BalanceMemento {

    private int balance;

    public BalanceMemento(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
}
