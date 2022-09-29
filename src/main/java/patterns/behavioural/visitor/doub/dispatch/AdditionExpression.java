package patterns.behavioural.visitor.doub.dispatch;

public class AdditionExpression extends Expression {

    private Expression left;
    private Expression right;

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }

    public AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }
}
