package patterns.structural.bridge.renderer.shape;

import com.google.inject.Inject;

import patterns.structural.bridge.renderer.Renderer;

public class Circle extends Shape {
    public void setRadius(float radius) {
        this.radius = radius;
    }

    private float radius;

    public float getRadius() {
        return radius;
    }

    @Inject
    public Circle(Renderer renderer) {
        super(renderer);
    }

    public Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }

    @Override
    public void resize(float factor) {
        radius *= factor;
    }
}
