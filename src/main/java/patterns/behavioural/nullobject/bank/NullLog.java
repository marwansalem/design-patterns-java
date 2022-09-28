package patterns.behavioural.nullobject.bank;

public final class NullLog implements Log {
    // Instances of this class are "Null Objects" that do not perform anything
    @Override
    public void info(String msg) {
    }

    @Override
    public void warn(String msg) {

    }
}
