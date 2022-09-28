package patterns.behavioural.interpreter.parser;

import patterns.behavioural.interpreter.parser.Element;

public class Integer implements Element {
    private int value;

    public Integer(int value) {
        this.value = value;
    }

    @Override
    public int eval() {
        return value;
    }
}
