package patterns.structural.adapter.drawing;

import java.util.Objects;

public class Line {
    public Point start;
    public Point end;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Line line = (Line) o;
        return getStart().equals(line.getStart()) && getEnd().equals(line.getEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStart(), getEnd());
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Line{" +
            "start=" + start +
            ", end=" + end +
            '}';
    }
}
