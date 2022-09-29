package patterns.behavioural.strategy.dynamic.formatter;

public class HtmlListFormatStrategy implements ListFormatStrategy {
    @Override
    public void start(StringBuilder sb) {
        sb.append("<ul>").append(System.lineSeparator());
    }

    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append("    <li>")
            .append(item)
            .append("</li>")
            .append(System.lineSeparator());
    }

    @Override
    public void end(StringBuilder sb) {
        sb.append("</ul>").append(System.lineSeparator());
    }
}
