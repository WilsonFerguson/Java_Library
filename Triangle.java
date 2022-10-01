import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends JPanel {
    
    public Point pos1, pos2, pos3;
    private Color color = Color.blue;
    private boolean filled = false;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.pos1 = new Point(x1, y1);
        this.pos2 = new Point(x2, y2);
        this.pos3 = new Point(x3, y3);
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3, Color color) {
        this.pos1 = new Point(x1, y1);
        this.pos2 = new Point(x2, y2);
        this.pos3 = new Point(x3, y3);
        this.color = color;
    }

    public Triangle(Point pos1, Point pos2, Point pos3) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
    }

    public Triangle(Point pos1, Point pos2, Point pos3, Color color) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public void color(Color color) {
        this.color = color;
    }

    public void color(int r, int g, int b) {
        color(new Color(r, g, b));
    }

    public void setPoint1(Point p1) {
        this.pos1 = p1;
    }

    public void setPoint1(double x, double y) {
        setPoint1(new Point(x, y));
    }

    public void setPoint2(Point p2) {
        this.pos2 = p2;
    }

    public void setPoint2(double x, double y) {
        setPoint2(new Point(x, y));
    }

    public void setPoint3(Point p3) {
        this.pos3 = p3;
    }

    public void setPoint3(double x, double y) {
        setPoint3(new Point(x, y));
    }

    public Color getColor() {
        return color;
    }

    public boolean getFilled() {
        return filled;
    }

    public Point getPoint1() {
        return pos1;
    }

    public Point getPoint2() {
        return pos2;
    }

    public Point getPoint3() {
        return pos3;
    }

    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.drawLine((int) pos1.x, (int) pos1.y, (int) pos2.x, (int) pos2.y);
        g.drawLine((int) pos2.x, (int) pos2.y, (int) pos3.x, (int) pos3.y);
        g.drawLine((int) pos3.x, (int) pos3.y, (int) pos1.x, (int) pos1.y);
        if (filled) {
            g.fillPolygon(new int[] {(int) pos1.x, (int) pos2.x, (int) pos3.x}, new int[] {(int) pos1.y, (int) pos2.y, (int) pos3.y}, 3);
        }
    }

    public static void draw(Graphics g, JPanel panel) {
        Triangle triangle = (Triangle) panel;
        Point pos1 = triangle.pos1;
        Point pos2 = triangle.pos2;
        Point pos3 = triangle.pos3;
        boolean filled = triangle.getFilled();
        g.setColor(triangle.getColor());
        g.drawLine((int) pos1.x, (int) pos1.y, (int) pos2.x, (int) pos2.y);
        g.drawLine((int) pos2.x, (int) pos2.y, (int) pos3.x, (int) pos3.y);
        g.drawLine((int) pos3.x, (int) pos3.y, (int) pos1.x, (int) pos1.y);
        if (filled) {
            g.fillPolygon(new int[] { (int) pos1.x, (int) pos2.x, (int) pos3.x },
                    new int[] { (int) pos1.y, (int) pos2.y, (int) pos3.y }, 3);
        }
    }
}