package patterns.structural.decorator.shape;

public class Square implements Shape {
    private float side;

    public Square() {
    }

    public Square(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return null;
    }
}
