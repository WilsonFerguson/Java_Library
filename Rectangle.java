import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends JPanel {

    private Point position, dimensions;
    private Color color;

    private double cornerRoundness;

    /**
     * Creates a new rectangle given {@code double} x, {@code double} y,
     * {@code double} width, {@code double} height, and {@code Color} color.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Rectangle(double x, double y, double width, double height, Color color) {
        position = new Point(x, y);
        dimensions = new Point(width, height);
        this.color = color;
    }

    /**
     * Creates a new rectangle given {@code double} x, {@code double} y,
     * {@code double} width, and {@code double} height.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Rectangle(double x, double y, double width, double height) {
        this(x, y, width, height, Color.BLACK);
    }

    /**
     * Creates a new rectangle given {@code Point} position, {@code Point}
     * dimensions, and {@code Color} color.
     * 
     * @param position
     * @param dimensions
     * @param color
     */
    public Rectangle(Point position, Point dimensions, Color color) {
        this(position.x, position.y, dimensions.x, dimensions.y, color);
    }

    /**
     * Creates a new rectangle given {@code Point} position and {@code Point}
     * dimensions.
     * 
     * @param position
     * @param dimensions
     */
    public Rectangle(Point position, Point dimensions) {
        this(position.x, position.y, dimensions.x, dimensions.y, Color.BLACK);
    }

    /**
     * Sets position of the rectangle given {@code Point} position.
     * 
     * @param position
     */
    public void setPos(Point position) {
        this.position = position.copy();
    }

    /**
     * Sets position of the rectangle given {@code double} x and {@code double} y.
     * 
     * @param x
     * @param y
     */
    public void setPos(double x, double y) {
        setPos(new Point(x, y));
    }

    /**
     * Sets dimensions of the rectangle given {@code Point} dimensions.
     * 
     * @param dimensions
     */
    public void setDimensions(Point dimensions) {
        this.dimensions = dimensions.copy();
    }

    /**
     * Sets dimensions of the rectangle given {@code double} width and
     * {@code double} height.
     * 
     * @param width
     * @param height
     */
    public void setDimensions(double width, double height) {
        setDimensions(new Point(width, height));
    }

    /**
     * Sets the color of the rectangle given {@code Color} color.
     * 
     * @param color
     */
    public void color(Color color) {
        this.color = color;
    }

    /**
     * Sets the color of the rectangle given {@code int} r, {@code int} g,
     * and {@code int} b.
     * 
     * @param r
     * @param g
     * @param b
     */
    public void color(int r, int g, int b) {
        color(new Color(r, g, b));
    }

    /**
     * Sets the color of the rectangle given {@code int} gray;
     * 
     * @param gray;
     */
    public void color(int gray) {
        color(gray, gray, gray);
    }

    /**
     * Sets the corner roundness of the rectangle given {@code double}
     * corner roundness.
     * 
     * @param cornerRoundness
     */
    public void setCornerRoundness(double cornerRoundness) {
        this.cornerRoundness = cornerRoundness;
    }

    /**
     * Returns the position of the rectangle as a {@code Point}.
     * 
     * @return position
     */
    public Point getPos() {
        return position.copy();
    }

    /**
     * Returns the dimensions of the rectangle as a {@code Point}.
     * 
     * @return dimensions
     */
    public Point getDimensions() {
        return dimensions.copy();
    }

    /**
     * Returns the color of the rectangle as a {@code Color}.
     * 
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the corner roundness of the rectangle as a {@code double}.
     * 
     * @return cornerRoundness
     */
    public double getCornerRoundness() {
        return cornerRoundness;
    }

    /**
     * Returns the center of the rectangle as a {@code Point}.
     * 
     * @return Point
     */
    public Point getCenter() {
        return new Point(position.x + dimensions.x / 2, position.y + dimensions.y / 2);
    }

    /**
     * Paints the rectangle given {@code Graphics} g.
     * 
     * @param graphics
     */
    public void paintComponent(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect((int) position.x, (int) position.y, (int) dimensions.x, (int) dimensions.y);
    }

    /**
     * This method is automatically handled by the {@link Window} class. Static
     * method to draw a rectangle to {@code Graphics} g given {@code JPanel}
     * panel.
     * 
     * @param graphics
     * @param panel
     */
    public static void draw(Graphics graphics, JPanel panel) {
        Rectangle rectangle = (Rectangle) panel;
        graphics.setColor(rectangle.getColor());

        Point pos = rectangle.getPos();
        Point dimensions = rectangle.getDimensions();
        int cornerRoundness = (int) rectangle.getCornerRoundness();

        graphics.fillRoundRect((int) pos.x, (int) pos.y, (int) dimensions.x, (int) dimensions.y, cornerRoundness,
                cornerRoundness);
    }
}