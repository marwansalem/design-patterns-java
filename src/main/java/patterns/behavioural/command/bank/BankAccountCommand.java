package patterns.behavioural.command.bank;

import java.util.List;

import com.google.common.collect.Lists;

public class BankAccountCommand implements Command {
    private BankAccount account;
    private boolean succeeded;
    public enum Action {
        DEPOSIT,
        WITHDRAW
    }
    @Override
    public void call() {
        switch (action) {
            case DEPOSIT:
                account.deposit(amount);
                succeeded = true;
                break;
            case WITHDRAW:
                succeeded = account.withdraw(amount);
                break;
        }
    }

    @Override
    public void undo() {
        if (!succeeded) return;
        // undoing by doing the reverse operation
        switch (action) {
            case DEPOSIT:
                account.withdraw(amount);
                break;
            case WITHDRAW:
                account.deposit(amount);
                break;
        }
    }

    private Action action;
    private int amount;

    public BankAccountCommand(BankAccount account, Action action, int amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }

    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        System.out.println(ba);

        List<Command> commands = List.of(
            new BankAccountCommand(ba, Action.DEPOSIT, 100),
            new BankAccountCommand(ba, Action.WITHDRAW, 1000)
        );

        for (Command c : commands) {
            c.call();
            System.out.println(ba);
        }

        for (Command c : Lists.reverse(commands)) {
            c.undo();
            System.out.println(ba);
        }
    }
}
