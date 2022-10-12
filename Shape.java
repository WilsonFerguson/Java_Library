import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Shape extends JPanel {
    private ArrayList<Point> points = new ArrayList<Point>();
    private Color color = Color.BLACK;

    /**
     * Creates a new shape.
     */
    public Shape() {
        super();
    }

    /**
     * Adds a {@code Point} point to the shape.
     * 
     * @param point
     */
    public void addPoint(Point point) {
        points.add(point);
    }

    /**
     * Adds a {@code double} x and {@code double} y to the shape.
     * 
     * @param x
     * @param y
     */
    public void addPoint(double x, double y) {
        points.add(new Point(x, y));
    }

    /**
     * Removes a {@code Point} point from the shape at a given {@code int} index.
     * 
     * @param index
     */
    public void removeAt(int index) {
        points.remove(index);
    }

    /**
     * Removes a {@code Point} point from the shape given a {@code Point} point.
     * 
     * @param point
     */
    public void removePoint(Point point) {
        points.remove(point);
    }

    /**
     * Clears all points from the shape.
     */
    public void clear() {
        points.clear();
    }

    /**
     * Sets the color of the shape given a {@code Color} color.
     * 
     * @param color
     */
    public void color(Color color) {
        this.color = color;
    }

    /**
     * Sets the color of the shape given an {@code int} r, {@code int} g, and
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
     * Sets the color of the shape given an {@code int} gray.
     * 
     * @param gray
     */
    public void color(int gray) {
        color(new Color(gray, gray, gray));
    }

    /**
     * Returns the color of the shape as a {@code Color} color.
     * 
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the points in the shape as an {@code ArrayList<Point>} points.
     * 
     * @return ArrayList<Point>
     */
    public ArrayList<Point> getPoints() {
        return points;
    }

    /**
     * Returns a {@link Graph} object of the shape. Currently not fully working.
     * 
     * @return Graph
     */
    public Graph toGraph() {
        double leftMostX = Double.MAX_VALUE;
        double rightMostX = Double.MIN_VALUE;
        double topMostY = Double.MAX_VALUE;
        for (Point point : points) {
            if (point.x < leftMostX) {
                leftMostX = point.x;
            }
            if (point.x > rightMostX) {
                rightMostX = point.x;
            }
            if (point.y < topMostY) {
                topMostY = point.y;
            }
        }
        Graph graph = new Graph(leftMostX - 20, topMostY - 20, rightMostX + 20, 0);
        graph.lineColor(color);
        for (Point point : points) {
            graph.addPoint(point);
        }
        return graph;
    }

    /**
     * This method is automatically handled by the {@link Window} class. Paints the
     * shape to a {@code Graphics} graphics.
     * 
     * @param graphics
     */
    public void paintComponent(Graphics graphics) {
        graphics.setColor(color);
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            graphics.drawLine((int) p1.x, (int) p1.y, (int) p2.x, (int) p2.y);
        }
    }

    /**
     * Static method to draw a shape to {@code Graphics} graphics given a
     * {@code JPanel} panel.
     * 
     * @param graphics
     * @param panel
     */
    public static void draw(Graphics graphics, JPanel panel) {
        Shape shape = (Shape) panel;
        ArrayList<Point> points = shape.getPoints();
        graphics.setColor(shape.getColor());
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            graphics.drawLine((int) p1.x, (int) p1.y, (int) p2.x, (int) p2.y);
        }
    }
}