package patterns.behavioural.command.bank;

public interface Command {
    void call();
    void undo();
}
