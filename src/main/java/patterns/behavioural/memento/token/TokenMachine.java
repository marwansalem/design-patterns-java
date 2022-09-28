package patterns.behavioural.memento.token;

import java.util.ArrayList;
import java.util.List;

public class TokenMachine {

    public List<Token> tokens = new ArrayList<>();

    public Memento addToken(int value)
    {
        // todo
        Token token = new Token(value);
        return addToken(token);
    }

    public Memento addToken(Token token)
    {
        // todo (yes, please do both overloads :)
        tokens.add(new Token(token.value));

        return new Memento(this.tokens);
    }

    public void revert(Memento m)
    {
        // todo
        tokens = m.getTokens();
    }
}
