package patterns.behavioural.visitor.acyclic;

public interface AdditionExpressionVisitor extends Visitor {
    void visit(AdditionExpression e);
}
