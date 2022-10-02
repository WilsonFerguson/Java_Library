import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import java.awt.Font;

public class Text extends JPanel {

    private Point pos = new Point(0, 0);

    private String text;
    private boolean centered;
    private Color color;

    private int fontSize = 12;
    private String font = "Arial";

    /**
     * Creates a new text given {@code String} text, {@code Point} pos, and
     * {@code Color} color.
     * 
     * @param text
     * @param pos
     * @param color
     */
    public Text(String text, Point pos, Color color) {
        this.pos = pos;
        this.text = text;
        this.centered = false;
        this.color = color;
    }

    /**
     * Creates a new text given {@code String} text, {@code double} x,
     * {@code double} y, and {@code Color} color.
     * 
     * @param text
     * @param x
     * @param y
     * @param color
     */
    public Text(String text, double x, double y, Color color) {
        this(text, new Point(x, y), color);
    }

    /**
     * Creates a new text given {@code String} text, {@code Point} pos, and
     * {@code double} width.
     * 
     * @param text
     * @param pos
     * @param width
     */
    public Text(String text, Point pos, double width) {
        this(text, pos, Color.BLACK);
    }

    /**
     * Creates a new text given {@code String} text, {@code double} x,
     * {@code double} y, and {@code double} width.
     * 
     * @param text
     * @param x
     * @param y
     * @param width
     */
    public Text(String text, double x, double y, double width) {
        this(text, new Point(x, y), width);
    }

    /**
     * Creates a new text given {@code String} text and {@code Point} pos.
     * 
     * @param text
     * @param pos
     */
    public Text(String text, Point pos) {
        this(text, pos, 0);
    }

    /**
     * Creates a new text given {@code String} text, {@code double} x, and
     * {@code double} y.
     * 
     * @param text
     * @param x
     * @param y
     */
    public Text(String text, double x, double y) {
        this(text, new Point(x, y));
    }

    /**
     * Sets color of text given {@code Color} color.
     * 
     * @param color
     */
    public void color(Color color) {
        this.color = color;
    }

    /**
     * Sets color of text given {@code int} r, {@code int} g, and {@code int} b.
     * 
     * @param r
     * @param g
     * @param b
     */
    public void color(int r, int g, int b) {
        color(new Color(r, g, b));
    }

    /**
     * Sets color of the text given {@code int} gray.
     * 
     * @param gray
     */
    public void color(int gray) {
        color(gray, gray, gray);
    }

    /**
     * Sets if the text is centered given {@code boolean} centered.
     * 
     * @param centered
     */
    public void setCentered(boolean centered) {
        this.centered = centered;
    }

    /**
     * Sets the font size of the text given {@code int} fontSize.
     * 
     * @param fontSize
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * Sets the font of the text given {@code String} font.
     * 
     * @param font
     */
    public void setFontType(String font) {
        this.font = font;
    }

    /**
     * Sets the text given {@code String} text.
     * 
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Sets the position of the text given {@code Point} pos.
     * 
     * @param pos
     */
    public void setPos(Point pos) {
        this.pos = pos;
    }

    /**
     * Sets the position of the text given {@code double} x and {@code double} y.
     * 
     * @param x
     * @param y
     */
    public void setPos(double x, double y) {
        setPos(new Point(x, y));
    }

    /**
     * Returns the color of the text as a {@code Color}.
     * 
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns whether the text is centered or not as a {@code boolean}.
     * 
     * @return boolean
     */
    public boolean getCentered() {
        return centered;
    }

    /**
     * Returns the font size of the text as an {@code int}.
     * 
     * @return int
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     * Returns the font of the text as a {@code String}.
     * 
     * @return String
     */
    public String getFontType() {
        return font;
    }

    /**
     * Returns the text as a {@code String}.
     * 
     * @return String
     */
    public String getText() {
        return text;
    }

    /**
     * Returns the position of the text as a {@code Point}.
     * 
     * @return Point
     */
    public Point getPos() {
        return pos.copy();
    }

    /**
     * Paints the text to a {@code Graphics} graphics
     * 
     * @param graphics
     */
    public void paintComponent(Graphics graphics) {
        graphics.setColor(color);
        graphics.setFont(new Font(font, Font.PLAIN, fontSize));
        int width = graphics.getFontMetrics().stringWidth(text);
        int height = graphics.getFontMetrics().getHeight();
        if (centered) {
            graphics.drawString(text, (int) (pos.x - width / 2), (int) pos.y + height / 2);
        } else {
            graphics.drawString(text, (int) pos.x, (int) pos.y + height / 2);
        }
    }

    /**
     * This method is automatically handled by the {@link Window} class. Static
     * method to draw text to {@code Graphics} graphics given {@code JPanel}
     * panel.
     * 
     * @param graphics
     * @param panel
     */
    public static void draw(Graphics graphics, JPanel panel) {
        Text text = (Text) panel;
        graphics.setColor(text.getColor());
        graphics.setFont(new Font(text.getFontType(), Font.PLAIN, text.getFontSize()));
        int textWidth = graphics.getFontMetrics().stringWidth(text.getText());
        int textHeight = graphics.getFontMetrics().getHeight();
        if (text.getCentered())
            graphics.drawString(text.getText(), (int) (text.getPos().x - textWidth / 2),
                    (int) text.getPos().y + textHeight / 2);
        else
            graphics.drawString(text.getText(), (int) text.getPos().x, (int) text.getPos().y + textHeight / 2);

    }

}