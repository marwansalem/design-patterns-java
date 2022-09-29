package patterns.behavioural.visitor.doub.dispatch;

public interface ExpressionVisitor {
    void visit(DoubleExpression e);
    void visit(AdditionExpression e);

}
