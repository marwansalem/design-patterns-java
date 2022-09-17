package patterns.structural.bridge.renderer.shape;

import patterns.structural.bridge.renderer.Renderer;

public abstract class Shape {
    protected Renderer renderer;
    protected Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
    public abstract void resize(float factor);
}
