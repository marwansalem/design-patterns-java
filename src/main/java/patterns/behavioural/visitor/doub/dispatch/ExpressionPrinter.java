package patterns.behavioural.visitor.doub.dispatch;

public class ExpressionPrinter implements ExpressionVisitor {
    private StringBuilder sb = new StringBuilder();
    @Override
    public void visit(DoubleExpression de) {
        sb.append(de.getValue());
    }

    @Override
    public void visit(AdditionExpression ae) {
        sb.append("(");
        ae.getLeft().accept(this);
        sb.append("+");
        ae.getRight().accept(this);
        sb.append(")");
    }

    @Override
    public String toString() {
        return sb.toString();
    }

    public static void main(String[] args) {
        AdditionExpression e = new AdditionExpression(
            new DoubleExpression(1),
            new AdditionExpression(
                new DoubleExpression(2),
                new DoubleExpression(3)
            )
        );
        ExpressionPrinter expressionPrinter = new ExpressionPrinter();
        e.accept(expressionPrinter);

        System.out.println(expressionPrinter);
    }
}
