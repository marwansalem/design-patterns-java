package patterns.behavioural.memento.token;

import java.util.List;
import java.util.stream.Collectors;

public class Memento {
    public List<Token> tokens;
    public Memento(List<Token> toSave) {
        this.tokens = toSave.stream()
            .map(t -> new Token(t.value))
            .collect(Collectors.toList());
    }

    public List<Token> getTokens() {
        return this.tokens.stream()
            .map(t -> new Token(t.value))
            .collect(Collectors.toList());
    }
}
