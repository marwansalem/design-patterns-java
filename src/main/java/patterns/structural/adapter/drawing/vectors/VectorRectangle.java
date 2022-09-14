package patterns.structural.adapter.drawing.vectors;

import patterns.structural.adapter.drawing.Line;
import patterns.structural.adapter.drawing.Point;

public class VectorRectangle extends VectorObject{
    public VectorRectangle(int x, int y, int width, int height) {
        add(new Line(new Point(x,y), new Point(x + width, y)));
        add(new Line(new Point(x + width, y), new Point(x + width, y + height)));
        add(new Line(new Point(x, y), new Point(x, y + height)));
        add(new Line(new Point(x, y + height), new Point(x + width, y + height)));
    }
}
