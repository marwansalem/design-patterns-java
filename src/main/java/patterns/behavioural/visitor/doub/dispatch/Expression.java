package patterns.behavioural.visitor.doub.dispatch;

public abstract class Expression {

    public abstract void accept(ExpressionVisitor visitor);

}
