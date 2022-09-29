package patterns.behavioural.visitor.acyclic;

public class ExpressionCalculator implements DoubleExpressionVisitor, AdditionExpressionVisitor {
    private double result = 0;
    @Override
    public void visit(DoubleExpression e) {
        result = e.getValue();
    }

    @Override
    public void visit(AdditionExpression e) {
        e.getLeft().accept(this);
        double a = result;
        e.getRight().accept(this);
        double b = result;

        result = a + b;
    }

    public double getResult() {
        return result;
    }

    public static void main(String[] args) {
        AdditionExpression e = new AdditionExpression(
            new AdditionExpression(
                new DoubleExpression(2),
                new DoubleExpression(3)
            ),
            new DoubleExpression(1)
        );
        ExpressionPrinter printer = new ExpressionPrinter();
        e.accept(printer);

        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        e.accept(expressionCalculator);
        System.out.println(printer + " = " + expressionCalculator.getResult());
    }
}