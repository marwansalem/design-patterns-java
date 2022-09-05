package patterns.creational.factory.point;

public class Point {
    public static enum CoordinateSystem {
        CARTESIAN,
        POLAR
    }

    /**
     * @param a is x if cartesian or
     * @param b is y if cartesian
     * cs
     */
    private double x;
    private double y;
    public Point(double a, double b, CoordinateSystem cs) {
        switch (cs) {
        case CARTESIAN:
            x = a;
            y = b;
            break;
        case POLAR:
            x = a * Math.cos(b);
            y = a * Math.sin(b);
            break;
        }
    }

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public static class Factory {
        public static Point newCartesianPoint(double x, double y) {
            return new Point(x,y);
        }

        public static Point newPolarPoint(double rho, double theta) {
            return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
        }
    }

    @Override
    public String toString() {
        return "Point{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }

    public static void main(String[] args) {
        Point point = Point.Factory.newPolarPoint(2, 3);
        System.out.println(point);
    }
}
