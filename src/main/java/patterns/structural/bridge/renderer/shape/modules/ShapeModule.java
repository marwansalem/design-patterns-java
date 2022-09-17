package patterns.structural.bridge.renderer.shape.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import patterns.structural.bridge.renderer.Renderer;
import patterns.structural.bridge.renderer.VectorRenderer;
import patterns.structural.bridge.renderer.shape.Circle;

public class ShapeModule extends AbstractModule {
    @Override
    protected void configure() {
      bind(Renderer.class).to(VectorRenderer.class);
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ShapeModule());
        injector.getInstance(Circle.class);
        Circle circle = injector.getInstance(Circle.class);
        circle.setRadius(3);
        circle.draw();
        circle.resize(2);
        circle.draw();
    }
}
