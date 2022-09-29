package patterns.behavioural.visitor.acyclic;

public class DoubleExpression extends Expression {
    // changed to public >.<
    private double value;

    public double getValue() {
        return value;
    }

    public DoubleExpression(double value) {
        this.value = value;
    }

    @Override
    public void accept(Visitor visitor) {
        if(visitor instanceof DoubleExpressionVisitor) {
            ((DoubleExpressionVisitor) visitor).visit(this);
        }
    }
}
