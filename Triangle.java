import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends JPanel {

    public Point pos1, pos2, pos3;
    private Color color = Color.black;
    private boolean filled = false;

    /**
     * Creates a new triangle give {@code Point} pos1, {@code Point} pos2,
     * {@code Point} pos3, and {@code Color} color.
     * 
     * @param pos1
     * @param pos2
     * @param pos3
     * @param color
     */
    public Triangle(Point pos1, Point pos2, Point pos3, Color color) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
        this.color = color;
    }

    /**
     * Creates a new triangle give {@code Point} pos1, {@code Point} pos2, and
     * {@code Point} pos3.
     * 
     * @param pos1
     * @param pos2
     * @param pos3
     */
    public Triangle(Point pos1, Point pos2, Point pos3) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
    }

    /**
     * Creates a new triangle give {@code double} x1, {@code double} y1,
     * {@code double} x2, {@code double} y2, {@code double} x3, {@code double} y3,
     * and {@code Color} color.
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @param color
     */
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3, Color color) {
        this.pos1 = new Point(x1, y1);
        this.pos2 = new Point(x2, y2);
        this.pos3 = new Point(x3, y3);
        this.color = color;
    }

    /**
     * Creates a new triangle give {@code double} x1, {@code double} y1,
     * {@code double} x2, {@code double} y2, and {@code double} x3, {@code double}
     * y3.
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     */
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.pos1 = new Point(x1, y1);
        this.pos2 = new Point(x2, y2);
        this.pos3 = new Point(x3, y3);
    }

    /**
     * Sets point 1 to {@code Point} pos1.
     * 
     * @param p1
     */
    public void setPoint1(Point p1) {
        this.pos1 = p1;
    }

    /**
     * Sets point 1 to {@code double} x1 and {@code double} y1.
     * 
     * @param x
     * @param y
     */
    public void setPoint1(double x, double y) {
        setPoint1(new Point(x, y));
    }

    /**
     * Sets point 2 to {@code Point} pos2.
     * 
     * @param p2
     */
    public void setPoint2(Point p2) {
        this.pos2 = p2;
    }

    /**
     * Sets point 2 to {@code double} x2 and {@code double} y2.
     * 
     * @param x
     * @param y
     */
    public void setPoint2(double x, double y) {
        setPoint2(new Point(x, y));
    }

    /**
     * Sets point 3 to {@code Point} pos3.
     * 
     * @param p3
     */
    public void setPoint3(Point p3) {
        this.pos3 = p3;
    }

    /**
     * Sets point 3 to {@code double} x3 and {@code double} y3.
     * 
     * @param x
     * @param y
     */
    public void setPoint3(double x, double y) {
        setPoint3(new Point(x, y));
    }

    /**
     * Sets the color of the triangle to {@code Color} color.
     * 
     * @param color
     */
    public void color(Color color) {
        this.color = color;
    }

    /**
     * Sets the color of the triangle to {@code int} r, {@code int} g, and
     * {@code int} b.
     * 
     * @param r
     * @param g
     * @param b
     */
    public void color(int r, int g, int b) {
        color(new Color(Math.min(r, 255), Math.min(g, 255), Math.min(b, 255)));
    }

    /**
     * Sets the color of the triangle to {@code int} gray.
     * 
     * @param gray
     */
    public void color(int gray) {
        color(gray, gray, gray);
    }

    /**
     * Sets the triangle to be filled or not given {@code boolean} filled.
     * 
     * @param filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Returns point 1 of the triangle as a {@code Point}.
     * 
     * @return Point
     */
    public Point getPoint1() {
        return pos1;
    }

    /**
     * Returns point 2 of the triangle as a {@code Point}.
     * 
     * @return Point
     */
    public Point getPoint2() {
        return pos2;
    }

    /**
     * Returns point 3 of the triangle as a {@code Point}.
     * 
     * @return Point
     */
    public Point getPoint3() {
        return pos3;
    }

    /**
     * Returns the color of the triangle as a {@code Color}.
     * 
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns whether the triangle is filled or not as a {@code boolean}.
     * 
     * @return boolean
     */
    public boolean getFilled() {
        return filled;
    }

    /**
     * Returns the area of the triangle.
     * 
     * @return double
     */
    public double getArea() {
        return Math.abs((pos1.x * (pos2.y - pos3.y) + pos2.x * (pos3.y - pos1.y) + pos3.x * (pos1.y - pos2.y)) / 2.0);
    }

    /**
     * Paints the component given a {@code Graphics} graphics.
     * 
     * @param graphics
     */
    public void paintComponent(Graphics graphics) {
        graphics.setColor(color);
        graphics.drawLine((int) pos1.x, (int) pos1.y, (int) pos2.x, (int) pos2.y);
        graphics.drawLine((int) pos2.x, (int) pos2.y, (int) pos3.x, (int) pos3.y);
        graphics.drawLine((int) pos3.x, (int) pos3.y, (int) pos1.x, (int) pos1.y);
        if (filled) {
            graphics.fillPolygon(new int[] { (int) pos1.x, (int) pos2.x, (int) pos3.x },
                    new int[] { (int) pos1.y, (int) pos2.y, (int) pos3.y }, 3);
        }
    }

    /**
     * This method is automatically handled by the {@link Window} class. Static
     * method to draw a triangle to a {@code Graphics} graphics given a
     * {@code JPanel} panel.
     * 
     * @param graphics
     * @param panel
     */
    public static void draw(Graphics graphics, JPanel panel) {
        Triangle triangle = (Triangle) panel;
        Point pos1 = triangle.pos1;
        Point pos2 = triangle.pos2;
        Point pos3 = triangle.pos3;
        boolean filled = triangle.getFilled();
        graphics.setColor(triangle.getColor());
        graphics.drawLine((int) pos1.x, (int) pos1.y, (int) pos2.x, (int) pos2.y);
        graphics.drawLine((int) pos2.x, (int) pos2.y, (int) pos3.x, (int) pos3.y);
        graphics.drawLine((int) pos3.x, (int) pos3.y, (int) pos1.x, (int) pos1.y);
        if (filled) {
            graphics.fillPolygon(new int[] { (int) pos1.x, (int) pos2.x, (int) pos3.x },
                    new int[] { (int) pos1.y, (int) pos2.y, (int) pos3.y }, 3);
        }
    }
}