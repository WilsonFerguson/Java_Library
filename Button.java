import java.awt.Color;
import java.awt.Graphics;

public class Button implements ClickableObject {

    private Point pos, dimensions;

    private Color color;
    private Color defaultColor;
    private Color hoverColor;
    private Color pressedColor;
    private Color textColor;

    private String text;

    private double cornerRoundness;

    /**
     * Creates a button with the given {@code String} text, {@code Point} position,
     * and {@code Point} dimensions, {@code Color} color.
     * 
     * @param text
     * @param pos
     * @param dimensions
     * @param color
     */
    public Button(String text, Point pos, Point dimensions, Color color) {
        this.text = text;
        this.pos = pos;
        this.dimensions = dimensions;
        this.defaultColor = color;
        this.hoverColor = color;
        this.pressedColor = color;
        this.color = color;
        this.textColor = Color.WHITE;
    }

    /**
     * Creates a button with the given {@code String} text, {@code Point} position,
     * and {@code Point} dimensions.
     * 
     * @param text
     * @param pos
     * @param dimensions
     */
    public Button(String text, Point pos, Point dimensions) {
        this(text, pos, dimensions, Color.RED);
    }

    /**
     * Creates a button with the given {@code String} text, {@code int} x position,
     * {@code int} y position, {@code int} width, {@code int} height, and
     * {@code Color} color.
     * 
     * @param text
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     */
    public Button(String text, double x, double y, double width, double height, Color color) {
        this(text, new Point(x, y), new Point(width, height), color);
    }

    /**
     * Creates a button with the given {@code String} text, {@code int} x position,
     * {@code int} y position, {@code int} width, and {@code int} height.
     * 
     * @param text
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Button(String text, double x, double y, double width, double height) {
        this(text, new Point(x, y), new Point(width, height));
    }

    /**
     * Sets the position of the button with the given {@code Point} position.
     * 
     * @param pos
     */
    public void setPosition(Point pos) {
        this.pos = pos;
    }

    /**
     * Sets the position of the button with the given {@code int} x position and
     * {@code int} y position.
     * 
     * @param x
     * @param y
     */
    public void setPosition(double x, double y) {
        this.pos = new Point(x, y);
    }

    /**
     * Sets the dimensions of the button with the given {@code Point} dimensions.
     * 
     * @param dimensions
     */
    public void setDimensions(Point dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * Sets the dimensions of the button with the given {@code int} width and
     * {@code int} height.
     * 
     * @param width
     * @param height
     */
    public void setDimensions(double width, double height) {
        this.dimensions = new Point(width, height);
    }

    /**
     * Sets the default color of the button with the given {@code Color} color.
     * 
     * @param color
     */
    public void defaultColor(Color color) {
        this.defaultColor = color;
    }

    /**
     * Sets the default color of the button with the given {@code int} red,
     * {@code int} green, and {@code int} blue.
     * 
     * @param r
     * @param g
     * @param b
     */
    public void defaultColor(int r, int g, int b) {
        defaultColor(new Color(Math.min(r, 255), Math.min(g, 255), Math.min(b, 255)));
    }

    /**
     * Sets the default color of the button with the given {@code int} gray.
     * 
     * @param gray
     */
    public void defaultColor(int gray) {
        defaultColor(gray, gray, gray);
    }

    /**
     * Sets the hover color of the button with the given {@code Color} color.
     * 
     * @param color
     */
    public void hoverColor(Color color) {
        this.hoverColor = color;
    }

    /**
     * Sets the hover color of the button with the given {@code int} red,
     * {@code int} green, and {@code int} blue.
     * 
     * @param r
     * @param g
     * @param b
     */
    public void hoverColor(int r, int g, int b) {
        hoverColor(new Color(Math.min(r, 255), Math.min(g, 255), Math.min(b, 255)));
    }

    /**
     * Sets the hover color of the button with the given {@code int} gray.
     * 
     * @param gray
     */
    public void hoverColor(int gray) {
        hoverColor(gray, gray, gray);
    }

    /**
     * Sets the pressed color of the button with the given {@code Color} color.
     * 
     * @param color
     */
    public void pressedColor(Color color) {
        this.pressedColor = color;
    }

    /**
     * Sets the pressed color of the button with the given {@code int} red,
     * {@code int} green, and {@code int} blue.
     * 
     * @param r
     * @param g
     * @param b
     */
    public void pressedColor(int r, int g, int b) {
        pressedColor(new Color(r, g, b));
    }

    /**
     * Sets the pressed color of the button with the given {@code int} gray.
     * 
     * @param gray
     */
    public void pressedColor(int gray) {
        pressedColor(gray, gray, gray);
    }

    /**
     * Sets the text color of the button with the given {@code Color} color.
     * 
     * @param color
     */
    public void textColor(Color color) {
        this.textColor = color;
    }

    /**
     * Sets the text color of the button with the given {@code int} red, {@code int}
     * green, and {@code int} blue.
     * 
     * @param r
     * @param g
     * @param b
     */
    public void textColor(int r, int g, int b) {
        textColor(new Color(Math.min(r, 255), Math.min(g, 255), Math.min(b, 255)));
    }

    /**
     * Sets the text color of the button with the given {@code int} gray.
     * 
     * @param gray
     */
    public void textColor(int gray) {
        textColor(gray, gray, gray);
    }

    /**
     * Sets the text of the button with the given {@code String} text.
     * 
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Sets the corner roundness of the button with the given {@code int} roundness.
     * 
     * @param cornerRoundness
     */
    public void setCornerRoundness(double cornerRoundness) {
        this.cornerRoundness = cornerRoundness;
    }

    /**
     * Returns the position of the button as a {@code Point}.
     * 
     * @return Point
     */
    public Point getPosition() {
        return pos;
    }

    /**
     * Returns the dimensions of the button as a {@code Point}.
     * 
     * @return Point
     */
    public Point getDimensions() {
        return dimensions;
    }

    /**
     * Returns the default color of the button as a {@code Color}.
     * 
     * @return Color
     */
    public Color getDefaultColor() {
        return defaultColor;
    }

    /**
     * Returns the current color of the button as a {@code Color}.
     * 
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the hover color of the button as a {@code Color}.
     * 
     * @return Color
     */
    public Color getHoverColor() {
        return hoverColor;
    }

    /**
     * Returns the pressed color of the button as a {@code Color}.
     * 
     * @return Color
     */
    public Color getPressedColor() {
        return pressedColor;
    }

    /**
     * Returns the text color of the button as a {@code Color}.
     * 
     * @return Color
     */
    public Color getTextColor() {
        return textColor;
    }

    /**
     * Returns the text of the button as a {@code String}.
     * 
     * @return String
     */
    public String getText() {
        return text;
    }

    /**
     * Returns the corner roundness of the button as a {@code int}.
     * 
     * @return double
     */
    public double getCornerRoundness() {
        return cornerRoundness;
    }

    /**
     * Code that is run when the button is pressed.
     */
    public void mousePressed() {
        color = pressedColor;
    }

    /**
     * Code that is run when the button is clicked.
     */
    public void mouseClicked() {
    }

    /**
     * Code that is run when the button is released.
     */
    public void mouseReleased() {
        color = hoverColor;
    }

    /**
     * Returns whether or not the button is being hovered over as a {@code boolean}.
     * Given the {@code int} x and {@code int} y coordinates of the mouse.
     * 
     * @param x
     * @param y
     * @return boolean
     */
    public boolean hover(double x, double y) {
        return x >= pos.x && x <= pos.x + dimensions.x && y >= pos.y && y <= pos.y + dimensions.y;
    }

    /**
     * Returns whether or not the button is being pressed as a {@code boolean}.
     * Given the {@code Point} mouse position.
     * 
     * @param p
     * @return boolean
     */
    public boolean hover(Point p) {
        return hover(p.x, p.y);
    }

    /**
     * Updates the button, must be called in the draw loop.
     * 
     * @param window
     */
    public void update(Window window) {
        if (hover(window.getMouse()) && !window.mousePressed()) {
            color = hoverColor;
        } else if (!hover(window.getMouse()) && !window.mousePressed()) {
            color = defaultColor;
        }
    }

    /**
     * Draws the button to the screen. This is handled automatically by the
     * {@link Window} class given {@code Graphics} graphics.
     * 
     * @param graphics
     */
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRoundRect((int) pos.x, (int) pos.y, (int) dimensions.x, (int) dimensions.y, (int) cornerRoundness,
                (int) cornerRoundness);
        graphics.setColor(textColor);
        // Draw centered text
        float fontSize = 0;
        for (int i = 0; i < 150; i++) {
            fontSize = i;
            graphics.setFont(graphics.getFont().deriveFont(fontSize));
            if (graphics.getFontMetrics().stringWidth(text) > dimensions.x * .85) {
                fontSize -= 1;
                break;
            }
        }
        graphics.setFont(graphics.getFont().deriveFont(fontSize));

        int textHeight = graphics.getFontMetrics().getHeight();

        int textX = (int) (pos.x + dimensions.x / 2 - graphics.getFontMetrics().stringWidth(text) / 2);
        int textY = (int) (pos.y + dimensions.y / 2 + graphics.getFontMetrics().getHeight() / 2) - textHeight / 4;
        graphics.drawString(text, textX, textY);
    }

}
