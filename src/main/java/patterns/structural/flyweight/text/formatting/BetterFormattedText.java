package patterns.structural.flyweight.text.formatting;

import java.util.ArrayList;
import java.util.List;

public class BetterFormattedText {
    private String plainText;
    private List<TextRange> formatting = new ArrayList<>();

    public BetterFormattedText(String plainText) {
        this.plainText = plainText;
    }

    public TextRange getRange(int start, int end) {
        TextRange range = new TextRange(start, end);
        formatting.add(range);
        return range;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            for (TextRange range: formatting) {
                if (range.covers(i) && range.capitalize)
                    c = Character.toUpperCase(c);
                // other formatting
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static class TextRange {
        public int start;
        public int end;
        public boolean capitalize, bold, italic;

        public TextRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean covers(int position) {
            return position >= start && position <= end;
        }
    }

    public static void main(String[] args) {
        BetterFormattedText bft = new BetterFormattedText("Let's go home");
        bft.getRange(0, 4).capitalize = true;
        System.out.println(bft);
    }
}
