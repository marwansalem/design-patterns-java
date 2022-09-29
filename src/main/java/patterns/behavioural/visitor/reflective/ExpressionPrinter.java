package patterns.behavioural.visitor.reflective;

public class ExpressionPrinter {
    public static void print(Expression e, StringBuilder sb) {
        // ugly if else / instanceof
        if (e.getClass() == DoubleExpression.class) {
            DoubleExpression de = (DoubleExpression)e;
            sb.append(de.value);
        } else if(e.getClass() == AdditionExpression.class) {
            AdditionExpression ae = ((AdditionExpression) e);
            sb.append("(");
            print(ae.left, sb);
            sb.append("+");
            print(ae.right, sb);
            sb.append(")");
        }
    }
}
