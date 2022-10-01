import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends JPanel {

    private double x, y, width, height;
    private Color color;

    private double cornerRoundness;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.BLACK;
    }

    public Rectangle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void color(Color color) {
        this.color = color;
    }

    public void color(int r, int g, int b) {
        color(new Color(r, g, b));
    }

    public void setPos(Point pos) {
        this.x = pos.x;
        this.y = pos.y;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setDimensions(Point dimensions) {
        this.width = dimensions.x;
        this.height = dimensions.y;
    }

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setCornerRoundness(double cornerRoundness) {
        this.cornerRoundness = cornerRoundness;
    }

    public Color getColor() {
        return color;
    }

    public Point getPos() {
        return new Point(x, y);
    }

    public Point getDimensions() {
        return new Point(width, height);
    }

    public double getCornerRoundness() {
        return cornerRoundness;
    }

    public Point getCenter() {
        return new Point(x + width / 2, y + height / 2);
    }

    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect((int) x, (int) y, (int) width, (int) height);
    }

    public static void draw(Graphics g, JPanel panel) {
        Rectangle rectangle = (Rectangle) panel;
        g.setColor(rectangle.getColor());

        Point pos = rectangle.getPos();
        Point dimensions = rectangle.getDimensions();
        int cornerRoundness = (int) rectangle.getCornerRoundness();

        g.fillRoundRect((int) pos.x, (int) pos.y, (int) dimensions.x, (int) dimensions.y, cornerRoundness, cornerRoundness);
    }
}