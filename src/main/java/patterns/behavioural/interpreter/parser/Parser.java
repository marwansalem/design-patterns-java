package patterns.behavioural.interpreter.parser;

import java.util.List;
import java.util.stream.Collectors;

import patterns.behavioural.interpreter.lexer.Token;

public class Parser {
    // DOES NOT WORK, skipped as it is just an example

    public static Element parse(List<Token> tokens) {
        BinaryOperation root = new BinaryOperation();
        boolean haveLHS = false;
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            System.out.println(token.getType());
            switch (token.getType()) {
                case INTEGER:
                    Integer integer = new Integer(java.lang.Integer.parseInt(token.getText()));
                    System.out.println(token.getText());
                    if (!haveLHS) {
                        haveLHS = true;
                        root.left = integer;
                    } else {
                        root.right = integer;
                    }
                    break;
                case PLUS:
                    root.type = BinaryOperation.Type.ADDITION;
                    break;
                case MINUS:
                    root.type = BinaryOperation.Type.SUBTRACTION;
                    break;
                case RPAREN:
                    break;
                case LPAREN:
                    int j = i + 1; // location of right parenthesis
                    for (; j < tokens.size(); ++j) {
                        Token other = tokens.get(j);

                        if (tokens.get(j).getType() == Token.Type.RPAREN) {
                            List<Token> subexpression = tokens
                                .stream()
                                .skip(i + 1)
                                .limit(j - i - 1)
                                .collect(Collectors.toList());
                            Element element = parse(subexpression);
                            if (!haveLHS) {
                                root.left = element;
                            } else {
                                root.right = element;
                            }
                            i = j;
                            break;
                        }
                    }
                    break;
            }
        }

        return root;
    }
}
