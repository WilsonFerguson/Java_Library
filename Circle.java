import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Circle extends JPanel {

    private Point pos;
    private Color color;
    private double radius = 10;

    /**
     * Creates a circle with the given {@code Point} pos, {@code double} radius, and
     * {@code Color} color.
     * 
     * @param pos
     * @param radius
     * @param color
     */
    public Circle(Point pos, double radius, Color color) {
        this.pos = pos;
        this.radius = radius;
        this.color = color;
    }

    /**
     * Creates a circle with the given {@code Point} pos, and {@code double} radius.
     * 
     * @param pos
     * @param radius
     */
    public Circle(Point pos, double radius) {
        this(pos, radius, Color.BLACK);
    }

    /**
     * Creates a circle with the given {@code int} x, {@code int} y, and
     * {@code double} radius.
     * 
     * @param pos
     */
    public Circle(double x, double y, double radius) {
        this(new Point(x, y), radius);
    }

    /**
     * Creates a circle with the given {@code int} x, {@code int} y, {@code double}
     * radius, and {@code Color} color.
     * 
     * @param pos
     */
    public Circle(double x, double y, double radius, Color color) {
        this(new Point(x, y), radius, color);
    }

    /**
     * Sets the position of the circle given a {@code Point} pos.
     * 
     * @param pos
     */
    public void setPos(Point pos) {
        this.pos = pos;
    }

    /**
     * Sets the position of the circle given an {@code int} x and {@code int} y.
     * 
     * @param x
     * @param y
     */
    public void setPos(double x, double y) {
        this.pos = new Point(x, y);
    }

    /**
     * Sets the color of the circle given a {@code Color} color.
     * 
     * @param color
     */
    public void color(Color color) {
        this.color = color;
    }

    /**
     * Sets the color of the circle given an {@code int} r, {@code int} g, and
     * {@code int} b.
     * 
     * @param r
     * @param g
     * @param b
     */
    public void color(int r, int g, int b) {
        color(new Color(r, g, b));
    }

    /**
     * Sets the color of the circle given an {@code int} gray.
     * 
     * @param gray
     */
    public void color(int gray) {
        color(gray, gray, gray);
    }

    /**
     * Sets the radius of the circle given a {@code double} radius.
     * 
     * @param radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Returns the position of the circle as a {@code Point}.
     * 
     * @return Point
     */
    public Point getPos() {
        return pos;
    }

    /**
     * Returns the color of the circle as a {@code Color}.
     * 
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the radius of the circle as a {@code double}.
     * 
     * @return double
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Paints the circle on the given {@code Graphics} graphics.
     * 
     * @param graphics
     */
    public void paintComponent(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval((int) (pos.x - radius), (int) (pos.y - radius), (int) (2 * radius), (int) (2 * radius));
    }

    /**
     * This method is automatically handled by the {@link Window} class. Static
     * method to draw a circle given a {@code Graphics} graphics and{@code JPanel}
     * panel.
     * 
     * @param g
     * @param panel
     */
    public static void draw(Graphics graphics, JPanel panel) {
        Circle circle = (Circle) panel;
        graphics.setColor(circle.getColor());

        Point pos = circle.getPos();
        int radius = (int) circle.getRadius();
        graphics.fillOval((int) (pos.x - radius), (int) (pos.y - radius), 2 * radius, 2 * radius);
    }

}