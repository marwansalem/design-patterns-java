package patterns.behavioural.strategy.dynamic.formatter;

import java.util.List;

public class TextProcessor {
    private StringBuilder sb = new StringBuilder();
    private ListFormatStrategy listFormatStrategy;

    public TextProcessor(ListFormatStrategy listFormatStrategy) {
        this.listFormatStrategy = listFormatStrategy;
    }

    public void setListFormatStrategy(ListFormatStrategy listFormatStrategy) {
        this.listFormatStrategy = listFormatStrategy;
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
