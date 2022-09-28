package patterns.behavioural.nullobject.bank;

public class ConsoleLog implements Log {
    @Override
    public void info(String msg) {
        System.out.println("INFO: " + msg);
    }

    @Override
    public void warn(String msg) {
        System.out.println("WARNING: " + msg);
    }
}
