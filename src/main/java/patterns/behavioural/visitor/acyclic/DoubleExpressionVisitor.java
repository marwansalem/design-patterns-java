package patterns.behavioural.visitor.acyclic;

public interface DoubleExpressionVisitor extends Visitor {
    void visit(DoubleExpression e);
}
