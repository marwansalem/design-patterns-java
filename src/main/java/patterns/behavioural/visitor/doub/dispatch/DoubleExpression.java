package patterns.behavioural.visitor.doub.dispatch;

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
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}
