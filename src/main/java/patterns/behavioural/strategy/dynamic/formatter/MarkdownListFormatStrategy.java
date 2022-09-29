package patterns.behavioural.strategy.dynamic.formatter;

public class MarkdownListFormatStrategy implements ListFormatStrategy {
    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append(" * ").append(item).append(System.lineSeparator());
    }
}
