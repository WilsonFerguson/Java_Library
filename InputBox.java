import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class InputBox implements ClickableObject, JavaLibrary {

    private Point pos, dimensions;

    private Color color;
    private Color defaultColor;
    private Color selectedColor;
    private Color textColor;

    private String placeholderText;
    private String text;

    private double cornerRoundness;

    private boolean selected;

    /**
     * Creates an input box with the given {@code Point} pos and {@code Point}
     * dimensions.
     * 
     * @param pos
     * @param dimensions
     */
    public InputBox(Window window, Point pos, Point dimensions) {
        this.pos = pos;
        this.dimensions = dimensions;

        color = new Color(255, 255, 255);
        defaultColor = new Color(255, 255, 255);
        selectedColor = new Color(200, 200, 200);
        textColor = new Color(0, 0, 0);

        placeholderText = "Type something...";
        text = "";

        cornerRoundness = 0;

        selected = false;

        window.addListener(this);
    }

    /**
     * Creates an input box with the given {@code int} x, {@code int} y, {@code int}
     * width, and {@code int} height.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public InputBox(Window window, double x, double y, double width, double height) {
        this(window, new Point(x, y), new Point(width, height));
    }

    /**
     * Sets the position of the input box given a {@code Point} pos.
     * 
     * @param pos
     */
    public void setPos(Point pos) {
        this.pos = pos;
    }

    /**
     * Sets the position of the input box given a {@code int} x and {@code int} y.
     * 
     * @param x
     * @param y
     */
    public void setPos(double x, double y) {
        setPos(new Point(x, y));
    }

    /**
     * Sets the dimensions of the input box given a {@code Point} dimensions.
     * 
     * @param dimensions
     */
    public void setDimensions(Point dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * Sets the dimensions of the input box given a {@code int} width and
     * {@code int} height.
     * 
     * @param width
     * @param height
     */
    public void setDimensions(double width, double height) {
        setDimensions(new Point(width, height));
    }

    /**
     * Sets the default color of the input box given a {@code Color} color.
     * 
     * @param color
     */
    public void defaultColor(Color color) {
        defaultColor = color;
    }

    /**
     * Sets the default color of the input box given a {@code int} r, {@code int} g,
     * and {@code int} b.
     * 
     * @param r
     * @param g
     * @param b
     */
    public void defaultColor(int r, int g, int b) {
        defaultColor(new Color(r, g, b));
    }

    /**
     * Sets the default color of the input box given a {@code int} gray.
     * 
     * @param gray
     */
    public void defaultColor(int gray) {
        defaultColor(gray, gray, gray);
    }

    /**
     * Sets the selected color of the input box given a {@code Color} color.
     * 
     * @param color
     */
    public void selectedColor(Color color) {
        selectedColor = color;
    }

    /**
     * Sets the selected color of the input box given a {@code int} r, {@code int}
     * g, and {@code int} b.
     * 
     * @param r
     * @param g
     * @param b
     */
    public void selectedColor(int r, int g, int b) {
        selectedColor(new Color(r, g, b));
    }

    /**
     * Sets the selected color of the input box given a {@code int} gray.
     * 
     * @param gray
     */
    public void selectedColor(int gray) {
        selectedColor(gray, gray, gray);
    }

    /**
     * Sets the text color of the input box given a {@code Color} color.
     * 
     * @param color
     */
    public void textColor(Color color) {
        textColor = color;
    }

    /**
     * Sets the text color of the input box given a {@code int} r, {@code int} g,
     * and {@code int} b.
     * 
     * @param r
     * @param g
     * @param b
     */
    public void textColor(int r, int g, int b) {
        textColor(new Color(r, g, b));
    }

    /**
     * Sets the text color of the input box given a {@code int} gray.
     * 
     * @param gray
     */
    public void textColor(int gray) {
        textColor(gray, gray, gray);
    }

    /**
     * Sets the placeholder text of the input box given a {@code String} placeholder
     * text.
     * 
     * @param placeholderText
     */
    public void setPlaceholderText(String placeholderText) {
        this.placeholderText = placeholderText;
    }

    /**
     * Sets the text of the input box given a {@code String} text.
     * 
     * @param cornerRoundness
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Sets the corner roundness of the input box given a {@code double} corner
     * roundness.
     * 
     * @param cornerRoundness
     */
    public void setCornerRoundness(double cornerRoundness) {
        this.cornerRoundness = cornerRoundness;
    }

    /**
     * Sets the input box to be selected given a {@code boolean} selected.
     * 
     * @param selected
     */
    public void selected(boolean selected) {
        this.selected = selected;
    }

    /**
     * Returns the position of the input box as a {@code Point}.
     * 
     * @return Point
     */
    public Point getPos() {
        return pos;
    }

    /**
     * Returns the dimensions of the input box as a {@code Point}.
     * 
     * @return Point
     */
    public Point getDimensions() {
        return dimensions;
    }

    /**
     * Returns the default color of the input box as a {@code Color}.
     * 
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the default color of the input box as a {@code Color}.
     * 
     * @return Color
     */
    public Color getDefaultColor() {
        return defaultColor;
    }

    /**
     * Returns the selected color of the input box as a {@code Color}.
     * 
     * @return Color
     */
    public Color getSelectedColor() {
        return selectedColor;
    }

    /**
     * Returns the text color of the input box as a {@code Color}.
     * 
     * @return Color
     */
    public Color getTextColor() {
        return textColor;
    }

    /**
     * Returns the placeholder text of the input box as a {@code String}.
     * 
     * @return String
     */
    public String getPlaceholderText() {
        return placeholderText;
    }

    /**
     * Returns the text of the input box as a {@code String}.
     * 
     * @return String
     */
    public String getText() {
        return text;
    }

    /**
     * Returns the corner roundness of the input box as a {@code double}.
     * 
     * @return double
     */
    public double getCornerRoundness() {
        return cornerRoundness;
    }

    /**
     * Returns whether the input box is selected as a {@code boolean}.
     * 
     * @return boolean
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * Updates the button, must be called in the draw loop. Must be given a
     * {@code Window} window.
     * 
     * @param window
     */
    public void update(Window window) {
        if (window.mousePressed() && !hover(window.getMouse())) {
            selected = false;
            color = defaultColor;
        }
    }

    /**
     * Automatically called by {@link Window} to draw the input box given a
     * {@code Graphics} graphics.
     * 
     * @param graphics
     */
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRoundRect((int) pos.getX(), (int) pos.getY(), (int) dimensions.getX(), (int) dimensions.getY(),
                (int) cornerRoundness, (int) cornerRoundness);

        if (text.equals(""))
            graphics.setColor(new Color(200, 200, 200));
        else
            graphics.setColor(textColor);
        graphics.setFont(new Font("Arial", Font.PLAIN, 17));
        int textHeight = graphics.getFontMetrics().getHeight();
        int textY = (int) (pos.y + dimensions.y / 2 + textHeight / 2) - textHeight / 4;

        if (text.equals("")) {
            graphics.drawString(placeholderText, (int) pos.getX() + 5, textY);
        } else {
            graphics.drawString(text, (int) pos.getX() + 5, textY);
        }
    }

    /**
     * Returns whether the input box is hovered over given a {@code Point} p.
     * 
     * @param p
     * @return boolean
     */
    public boolean hover(Point p) {
        double pX = p.x;
        double pY = p.y;
        return pos.x <= pX && pX <= pos.x + dimensions.x && pos.y <= pY && pY <= pos.y + dimensions.y;
    }

    /**
     * Returns whether the input box is hovered over given a {@code double} x and
     * {@code double} y.
     * 
     * @param x
     * @param y
     * @return boolean
     */
    public boolean hover(double x, double y) {
        return hover(new Point(x, y));
    }

    // ********************************************************** IMPLEMENTED
    // METHODS (AUTOMATICALLY CALLED BY WINDOW CLASS)
    // **********************************************************//
    /**
     * Method is automatically called by {@link Window} when the input box is
     * clicked.
     */
    public void mouseClicked() {
    }

    /**
     * Method is automatically called by {@link Window} when the input box is
     * pressed.
     */
    public void mousePressed() {
        selected = true;
        color = selectedColor;
    }

    /**
     * Method is automatically called by {@link Window} when the input box is
     * released.
     */
    public void mouseReleased() {
    }

    public void mousePressed(MouseEvent evt) {

    }

    public void mouseClicked(MouseEvent evt) {

    }

    public void mouseReleased(MouseEvent evt) {

    }

    public void mouseDragged(MouseEvent evt) {

    }

    public void mouseWheelMoved(MouseWheelEvent evt) {

    }

    public void keyPressed(KeyEvent evt) {

    }

    public void keyReleased(KeyEvent evt) {

    }

    public void keyTyped(KeyEvent evt) {
        String key = Helper.keyCodeToString(evt);
        if (key.equals("Escape")) {
            selected = false;
            color = defaultColor;
        } else if (key.equals("Backspace")) {
            if (text.length() > 0)
                text = text.substring(0, text.length() - 1);
        } else if (key.equals("Enter")) {
            selected = false;
            color = defaultColor;
        } else if (key.length() == 1) {
            text += key;
        }
    }
}
