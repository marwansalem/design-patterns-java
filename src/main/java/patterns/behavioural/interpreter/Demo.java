package patterns.behavioural.interpreter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import patterns.behavioural.interpreter.lexer.Lexer;
import patterns.behavioural.interpreter.lexer.Token;
import patterns.behavioural.interpreter.parser.Element;
import patterns.behavioural.interpreter.parser.Parser;

public class Demo {
    public static void main(String[] args) {
        String input = "(13+4)-(12+1)";
        List<Token> tokens = Lexer.lex(input);
        System.out.println(tokens.stream().map(Objects::toString).collect(Collectors.joining("\t")));
        Element parsed = Parser.parse(tokens);
        System.out.println(input + " = " + parsed.eval());
    }
}
