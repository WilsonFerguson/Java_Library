import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Line extends JPanel {

    private double x1, y1, x2, y2;
    private Color color;
    private double thickness = 1;

    /**
     * Creates a new line given {@code double} x1, {@code double} y1, {@code double}
     * x2, {@code double} y2, and {@code Color} color.
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public Line(double x1, double y1, double x2, double y2, Color color) {
        super();
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    /**
     * Creates a new line given {@code double} x1, {@code double} y1,
     * {@code double}, {@code double} x2, and {@code double} y2.
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public Line(double x1, double y1, double x2, double y2) {
        super();
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = Color.BLACK;
    }

    /**
     * Creates a new line given {@code Point} p1, {@code Point} p2, and
     * {@code Color} color.
     * 
     * @param p1
     * @param p2
     * @param color
     */
    public Line(Point p1, Point p2, Color color) {
        super();
        this.x1 = p1.x;
        this.y1 = p1.y;
        this.x2 = p2.x;
        this.y2 = p2.y;
        this.color = color;
    }

    /**
     * Creates a new line given {@code Point} p1 and {@code Point} p2.
     * 
     * @param p1
     * @param p2
     */
    public Line(Point p1, Point p2) {
        super();
        this.x1 = p1.x;
        this.y1 = p1.y;
        this.x2 = p2.x;
        this.y2 = p2.y;
        this.color = Color.BLACK;
    }

    /**
     * Sets the first point of the line given {@code Point} p1.
     * 
     * @param p1
     */
    public void setPoint1(Point p1) {
        this.x1 = p1.x;
        this.y1 = p1.y;
    }

    /**
     * Sets the first point of the line given {@code double} x1 and {@code double}
     * y1.
     * 
     * @param x
     * @param y
     */
    public void setPoint1(double x, double y) {
        setPoint1(new Point(x, y));
    }

    /**
     * Sets the second point of the line given {@code Point} p2.
     * 
     * @param p2
     */
    public void setPoint2(Point p2) {
        this.x2 = p2.x;
        this.y2 = p2.y;
    }

    /**
     * Sets the second point of the line given {@code double} x2 and {@code double}
     * y2.
     * 
     * @param x
     * @param y
     */
    public void setPoint2(double x, double y) {
        setPoint2(new Point(x, y));
    }

    /**
     * Sets the color of the line given {@code Color} color.
     * 
     * @param color
     */
    public void color(Color color) {
        this.color = color;
    }

    /**
     * Sets the color of the line given {@code int} r, {@code int} g, and
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
     * Sets the color of the line given {@code int} gray.
     * 
     * @param gray
     */
    public void color(int gray) {
        color(new Color(gray, gray, gray));
    }

    /**
     * Sets the thickness of the line given {@code double} thickness.
     * 
     * @param thickness
     */
    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    /**
     * Returns the first point of the line as a {@code Point}.
     * 
     * @return point
     */
    public Point getPoint1() {
        return new Point(x1, y1);
    }

    /**
     * Returns the second point of the line as a {@code Point}.
     * 
     * @return point
     */
    public Point getPoint2() {
        return new Point(x2, y2);
    }

    /**
     * Returns the color of the line as a {@code Color}.
     * 
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the thickness of the line as a {@code double}.
     * 
     * @return thickness
     */
    public double getThickness() {
        return thickness;
    }

    /**
     * Paints the line on the {@code Graphics} graphics.
     * 
     * @param graphics
     */
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.setStroke(new BasicStroke((float) thickness));
        g2d.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        g2d.dispose();
    }

    /**
     * This method is automatically handled by the {@link Window} class. Static
     * method to draw a line given a {@code Graphics} g, and {@code JPanel}
     * panel.
     * 
     * @param g
     * @param panel
     */
    public static void draw(Graphics graphics, JPanel panel) {
        Line line = (Line) panel;
        graphics.setColor(line.getColor());
        graphics.drawLine((int) line.getPoint1().x, (int) line.getPoint1().y, (int) line.getPoint2().x,
                (int) line.getPoint2().y);
    }

}