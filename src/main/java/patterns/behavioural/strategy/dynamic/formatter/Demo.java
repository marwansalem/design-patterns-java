package patterns.behavioural.strategy.dynamic.formatter;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // you can possibly determine which processor you want from the user
        TextProcessor tp = new TextProcessor(new HtmlListFormatStrategy());
        tp.appendList(List.of("1", "2", "3"));
        System.out.println(tp);

        tp.clear();
        tp.setListFormatStrategy(new MarkdownListFormatStrategy());
        tp.appendList(List.of("Water", "Tea", "Juice", "Coffee"));
        System.out.println(tp);
    }
}
