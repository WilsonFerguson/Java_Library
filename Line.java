import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Line extends JPanel {

    private double x1, y1, x2, y2;
    private Color color;
    private double thickness = 1;

    public Line(double x1, double y1, double x2, double y2) {
        super();
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = Color.BLACK;
    }

    public Line(double x1, double y1, double x2, double y2, Color color) {
        super();
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    public Line(Point p1, Point p2) {
        super();
        this.x1 = p1.x;
        this.y1 = p1.y;
        this.x2 = p2.x;
        this.y2 = p2.y;
        this.color = Color.BLACK;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public void color(Color color) {
        this.color = color;
    }

    public void color(int r, int g, int b) {
        color(new Color(r, g, b));
    }

    public void setPoint1(Point p1) {
        this.x1 = p1.x;
        this.y1 = p1.y;
    }

    public void setPoint1(double x, double y) {
        setPoint1(new Point(x, y));
    }

    public void setPoint2(Point p2) {
        this.x2 = p2.x;
        this.y2 = p2.y;
    }

    public void setPoint2(double x, double y) {
        setPoint2(new Point(x, y));
    }

    public double getThickness() {
        return thickness;
    }

    public Color getColor() {
        return color;
    }

    public Point getPoint1() {
        return new Point(x1, y1);
    }

    public Point getPoint2() {
        return new Point(x2, y2);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke((float) thickness));
        g2d.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        g2d.dispose();
    }

    public static void draw(Graphics g, JPanel panel) {
        Line line = (Line) panel;
        g.setColor(line.getColor());
        g.drawLine((int) line.getPoint1().x, (int) line.getPoint1().y, (int) line.getPoint2().x,
                (int) line.getPoint2().y);
    }

}