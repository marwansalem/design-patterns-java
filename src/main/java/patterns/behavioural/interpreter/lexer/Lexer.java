package patterns.behavioural.interpreter.lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    public static List<Token> lex(String input) {
        List<Token> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '+':
                    result.add(new Token(Token.Type.PLUS, "+"));
                    break;
                case '-':
                    result.add(new Token(Token.Type.MINUS, "-"));
                    break;
                case '(':
                    result.add(new Token(Token.Type.LPAREN, "("));
                    break;
                case ')':
                    result.add(new Token(Token.Type.RPAREN, ")"));
                    break;
                default:
                    StringBuilder sb = new StringBuilder("" + c);
                    for (int j = i + 1; j < input.length(); j++) {
                        if (Character.isDigit(input.charAt(j))) {
                            sb.append(input.charAt(j));
                            i++;
                        } else {
                            result.add(
                                new Token(
                                    Token.Type.INTEGER,
                                    sb.toString()
                                )
                            );
                                break;
                        }
                    }
                    break;
            }
        }

        return result;
    }
}
