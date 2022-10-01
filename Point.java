public class Point {

    public double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void subtract(Point point) {
        this.x -= point.x;
        this.y -= point.y;
    }

    public void subtract(double x, double y) {
        this.x -= x;
        this.y -= y;
    }

    public void add(Point point) {
        this.x += point.x;
        this.y += point.y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void multiply(Point point) {
        this.x *= point.x;
        this.y *= point.y;
    }

    public void multiply(double x, double y) {
        this.x *= x;
        this.y *= y;
    }

    public void multiply(double multiplier) {
        this.x *= multiplier;
        this.y *= multiplier;
    }

    public void divide(Point point) {
        this.x /= point.x;
        this.y /= point.y;
    }

    public void divide(double x, double y) {
        this.x /= x;
        this.y /= y;
    }

    public void divide(double divisor) {
        this.x /= divisor;
        this.y /= divisor;
    }

    public void setMag(double magnitude) {
        // Sets the length of the vector to the given value
        double angle = this.getAngle();
        this.x = (double) (magnitude * Math.cos(angle));
        this.y = (double) (magnitude * Math.sin(angle));
    }

    public double getMag() {
        // Returns the length of the vector
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public double getAngle() {
        // Returns the angle of the vector
        return Math.atan2(this.y, this.x);
    }

    public void rotate(double angle) {
        double x = this.x;
        double y = this.y;

        this.x = (double) (x * Math.cos(angle) - y * Math.sin(angle));
        this.y = (double) (x * Math.sin(angle) + y * Math.cos(angle));
    }

    public double dist(Point point) {
        return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2));
    }

    public double dist(double x, double y) {
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
    }

    public double dot(Point point) {
        return this.x * point.x + this.y * point.y;
    }

    public Point copy() {
        return new Point(this.x, this.y);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static Point add(Point point1, Point point2) {
        return new Point(point1.x + point2.x, point1.y + point2.y);
    }

    public static Point subtract(Point point1, Point point2) {
        return new Point(point1.x - point2.x, point1.y - point2.y);
    }

    public static Point multiply(Point point1, Point point2) {
        return new Point(point1.x * point2.x, point1.y * point2.y);
    }

    public static Point divide(Point point1, Point point2) {
        return new Point(point1.x / point2.x, point1.y / point2.y);
    }

    public static Point multiply(Point point, double multiplier) {
        return new Point(point.x * multiplier, point.y * multiplier);
    }

    public static Point divide(Point point, double divisor) {
        return new Point(point.x / divisor, point.y / divisor);
    }

    public static double dist(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
    }

    public static double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static double dot(Point point1, Point point2) {
        return point1.x * point2.x + point1.y * point2.y;
    }
}