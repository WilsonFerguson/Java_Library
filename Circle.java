import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Circle extends JPanel {

    private Point pos;
    private double radius = 10;
    private Color color;

    public Circle(Point pos, double radius, Color color) {
        this.pos = pos;
        this.radius = radius;
        this.color = color;
    }

    public Circle(Point pos, double radius) {
        this(pos, radius, Color.BLACK);
    }

    public Circle(double x, double y, double radius) {
        this(new Point(x, y), radius);
    }

    public Circle(double x, double y, double radius, Color color) {
        this(new Point(x, y), radius, color);
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public void setPos(double x, double y) {
        this.pos = new Point(x, y);
    }

    public void color(Color color) {
        this.color = color;
    }

    public void color(int r, int g, int b) {
        color(new Color(r, g, b));
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getPos() {
        return pos;
    }

    public Color getColor() {
        return color;
    }

    public double getRadius() {
        return radius;
    }

    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (pos.x - radius), (int) (pos.y - radius), (int) (2 * radius), (int) (2 * radius));
    }

    public static void draw(Graphics g, JPanel panel) {
        Circle circle = (Circle) panel;
        g.setColor(circle.getColor());

        Point pos = circle.getPos();
        int radius = (int) circle.getRadius();
        g.fillOval((int) (pos.x - radius), (int) (pos.y - radius), 2 * radius, 2 * radius);
    }

}