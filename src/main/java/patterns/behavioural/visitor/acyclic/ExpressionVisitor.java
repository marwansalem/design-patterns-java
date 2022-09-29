package patterns.behavioural.visitor.acyclic;

public interface ExpressionVisitor extends Visitor {
    void visit(Expression exp);
}
