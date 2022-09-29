package patterns.behavioural.strategy.dynamic.formatter;

public interface ListFormatStrategy {
    default void start(StringBuilder sb) {}
    void addListItem(StringBuilder sb, String item);
    default void end(StringBuilder sb) {}
}
