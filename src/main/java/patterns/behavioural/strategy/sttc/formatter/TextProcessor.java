package patterns.behavioural.strategy.sttc.formatter;

import java.util.List;
import java.util.function.Supplier;

import patterns.behavioural.strategy.dynamic.formatter.ListFormatStrategy;

public class TextProcessor<LS extends ListFormatStrategy> {
    private StringBuilder sb = new StringBuilder();
    private final LS listFormatStrategy;

    public TextProcessor(Supplier<? extends LS> ctor) {
        listFormatStrategy = ctor.get();
    }


    public void appendList(List<String> items) {
        listFormatStrategy.start(sb);
        items.forEach(item -> listFormatStrategy.addListItem(sb, item));
        listFormatStrategy.end(sb);
    }

    public void clear() {
        sb.setLength(0);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
