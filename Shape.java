import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Shape extends JPanel {
    private ArrayList<Point> points = new ArrayList<Point>();
    private Color color = Color.BLACK;

    public Shape() {
        super();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void addPoint(double x, double y) {
        points.add(new Point(x, y));
    }

    public void removeAt(int index) {
        points.remove(index);
    }

    public void removePoint(Point point) {
        points.remove(point);
    }

    public void clear() {
        points.clear();
    }

    public void color(Color color) {
        this.color = color;
    }

    public void color(int r, int g, int b) {
        color(new Color(r, g, b));
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void paintComponent(Graphics g) {
        g.setColor(color);
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine((int) p1.x, (int) p1.y, (int) p2.x, (int) p2.y);
        }
    }

    public static void draw(Graphics g, JPanel panel) {
        Shape shape = (Shape) panel;
        ArrayList<Point> points = shape.getPoints();
        g.setColor(shape.getColor());
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine((int) p1.x, (int) p1.y, (int) p2.x, (int) p2.y);
        }
    }
}