package patterns.structural.adapter.drawing.vectors;

import java.util.Arrays;
import java.util.List;

import patterns.structural.adapter.drawing.Line;
import patterns.structural.adapter.drawing.LineToPointAdapter;
import patterns.structural.adapter.drawing.Point;

public class Demo {
    private static final List<VectorObject> vectorObjects = Arrays.asList(
        new VectorRectangle(1, 1, 10,12),
        new VectorRectangle(3, 3 , 6, 8)
    );
    public static void drawPoint(Point p) {
        System.out.println(".");
    }

    public static void draw() {
        for (VectorObject vo : vectorObjects) {
            for (Line line : vo) {
                LineToPointAdapter adapter = new LineToPointAdapter(line);
                adapter.forEach(Demo::drawPoint);
            }
        }
    }
    public static void main(String[] args) {
        draw();
        draw();
    }
}
