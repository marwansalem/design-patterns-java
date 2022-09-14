package patterns.structural.adapter.drawing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineToPointAdapter extends ArrayList<Point> {
    private static int count = 0;
    // irrelevant caching behavior
    private static Map<Line, List<Point>> cachedLines = new HashMap<>();
    public LineToPointAdapter(Line line) {
        if (cachedLines.containsKey(line)) {
            addAll(cachedLines.get(line));
            System.out.println("Serving from cached lines");
            return;
        }
        System.out.println(
            String.format("%d: Generating point for line [%d,%d]-[%d,%d]",
                ++count, line.start.getX(), line.start.getY(), line.end.getX(), line.end.getY())
        );

        int left = Math.min(line.start.getX(), line.end.getX());
        int right = Math.max(line.start.getX(), line.end.getX());
        int top = Math.max(line.start.getY(), line.end.getY());
        int bottom = Math.min(line.start.getY(), line.end.getY());

        int dx = right - left;
        int dy = line.end.getY() - line.start.getY();
        if (dx == 0) {
            for (int y = top; y >= bottom ; y--) {
                add(new Point(left, y));
            }
        } else if (dy == 0) {
            for (int x = left; x <= right ; x++) {
                add(new Point(x, top));
            }
        }
        cachedLines.put(line, this);
    }
}
