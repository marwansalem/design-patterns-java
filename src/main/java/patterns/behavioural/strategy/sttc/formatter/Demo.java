package patterns.behavioural.strategy.sttc.formatter;

import java.util.List;

import patterns.behavioural.strategy.dynamic.formatter.HtmlListFormatStrategy;
import patterns.behavioural.strategy.dynamic.formatter.MarkdownListFormatStrategy;

public class Demo {
    public static void main(String[] args) {
        TextProcessor<MarkdownListFormatStrategy> mdTextProcessor = new TextProcessor<>(MarkdownListFormatStrategy::new);

        mdTextProcessor.appendList(List.of("alpha", "beta", "gamma"));
        System.out.println(mdTextProcessor);

        TextProcessor<HtmlListFormatStrategy> htmlTextProcessor = new TextProcessor<>(HtmlListFormatStrategy::new);
        htmlTextProcessor.appendList(List.of("alpha", "beta", "gamma"));
        System.out.println(htmlTextProcessor);
    }
}
