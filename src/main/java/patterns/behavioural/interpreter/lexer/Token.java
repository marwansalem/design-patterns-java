package patterns.behavioural.interpreter.lexer;

public class Token {
    public enum Type {
        INTEGER,
        PLUS,
        MINUS,
        LPAREN,
        RPAREN
    }

    public Token(Type type, String text) {
        this.type = type;
        this.text = text;
    }

    public Type getType() {
        return type;
    }

    private Type type;
    private String text;

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "`"  + text + "`";
    }
}
