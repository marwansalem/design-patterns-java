package patterns.behavioural.interpreter.quiz;

import java.util.HashMap;
import java.util.Map;

class ExpressionProcessor
{
    public Map<Character, Integer> variables = new HashMap<>();
    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    public int calculate(String expression)
    {
        int result = 0;
        String []parts = expression.split("[+-]");
        int multiplier = 1;
        int i = -1;
        for (String tok : parts) {
            i++;

            Integer num = tryParse(tok);
            if ("+".equals(tok)) {
                multiplier = 1;
                continue;
            } else if("-".equals(tok)) {
                multiplier = -1;
                continue;
            }

            int value = 0;
            if (num == null ) {
                if (tok.length() != 1 || !variables.containsKey(tok.charAt(0))) {
                    // fail
                    return 0;
                }
                value = variables.get(tok.charAt(0));
            } else {
                value = num;
            }

            result += multiplier * value;
        }
        return result;
    }

    public static void main(String[] args) {
        ExpressionProcessor expressionProcessor = new ExpressionProcessor();
        int calculate = expressionProcessor.calculate("1+xy");
        System.out.println(calculate);
        expressionProcessor.variables.put('x', 3);
        System.out.println(expressionProcessor.calculate("10-2-x"));
    }
}