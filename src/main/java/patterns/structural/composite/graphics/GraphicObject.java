package patterns.structural.composite.graphics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphicObject {
    // By Default a graphic object is group of other objects
    // But it can be an individual (scalar) object.
    protected String name = "Group";
    protected String color;
    protected List<GraphicObject> children = new ArrayList<>();
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GraphicObject() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        print(sb, 0);
        return sb.toString();
    }

    public void addChild(GraphicObject child) {
        children.add(child);
    }

    private void print(StringBuilder sb, int depth) {
        sb.append(String.join("", Collections.nCopies(depth, "*")))
            .append(depth > 0 ? " " : "")
            .append((color == null || color.isEmpty()) ? "": color + " ")
            .append(getName())
            .append(System.lineSeparator());
        children.forEach(child -> child.print(sb, depth + 1));
    }
}
