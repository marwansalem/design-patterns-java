package patterns.structural.composite.graphics.client;

import patterns.structural.composite.graphics.Circle;
import patterns.structural.composite.graphics.GraphicObject;
import patterns.structural.composite.graphics.Square;

public class Demo {
    public static void main(String[] args) {
        GraphicObject drawing = new GraphicObject();
        drawing.setName("My Drawing");
        drawing.addChild(new Square("Red"));
        drawing.addChild(new Circle("Yellow"));

        GraphicObject subGroup = new GraphicObject();
        drawing.addChild(subGroup);
        subGroup.setName("Blue Group");
        subGroup.addChild(new Circle("Blue"));
        subGroup.addChild(new Square("Blue"));



        System.out.println(drawing);

        System.out.println(subGroup);

    }
}
