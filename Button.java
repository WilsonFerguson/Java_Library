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

    public Button(String text, Point pos, Point dimensions) {
        this(text, pos, dimensions, Color.RED);
    }

    public Button(String text, double x, double y, double width, double height, Color color) {
        this(text, new Point(x, y), new Point(width, height), color);
    }

    public Button(String text, double x, double y, double width, double height) {
        this(text, new Point(x, y), new Point(width, height));
    }

    public void setPosition(Point pos) {
        this.pos = pos;
    }

    public void setPosition(double x, double y) {
        this.pos = new Point(x, y);
    }

    public void setDimensions(Point dimensions) {
        this.dimensions = dimensions;
    }

    public void setDimensions(double width, double height) {
        this.dimensions = new Point(width, height);
    }

    public void defaultColor(Color color) {
        this.defaultColor = color;
    }

    public void defaultColor(int r, int g, int b) {
        defaultColor(new Color(r, g, b));
    }

    public void defaultColor(int gray) {
        defaultColor(gray, gray, gray);
    }

    public void hoverColor(Color color) {
        this.hoverColor = color;
    }

    public void hoverColor(int r, int g, int b) {
        hoverColor(new Color(r, g, b));
    }

    public void hoverColor(int gray) {
        hoverColor(gray, gray, gray);
    }

    public void pressedColor(Color color) {
        this.pressedColor = color;
    }

    public void pressedColor(int r, int g, int b) {
        pressedColor(new Color(r, g, b));
    }

    public void pressedColor(int gray) {
        pressedColor(gray, gray, gray);
    }

    public void textColor(Color color) {
        this.textColor = color;
    }

    public void textColor(int r, int g, int b) {
        textColor(new Color(r, g, b));
    }

    public void textColor(int gray) {
        textColor(gray, gray, gray);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCornerRoundness(double cornerRoundness) {
        this.cornerRoundness = cornerRoundness;
    }

    public Point getPosition() {
        return pos;
    }

    public Point getDimensions() {
        return dimensions;
    }

    public Color getColor() {
        return color;
    }

    public Color getHoverColor() {
        return hoverColor;
    }

    public Color getPressedColor() {
        return pressedColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public String getText() {
        return text;
    }

    public double getCornerRoundness() {
        return cornerRoundness;
    }

    public void mousePressed() {
        color = pressedColor;
    }

    public void mouseClicked() {
        System.out.println("Clicked");
    }

    public void mouseReleased() {
        color = hoverColor;
    }

    public boolean hover(double x, double y) {
        return x >= pos.x && x <= pos.x + dimensions.x && y >= pos.y && y <= pos.y + dimensions.y;
    }

    public boolean hover(Point p) {
        return hover(p.x, p.y);
    }

    public void update(Window window) {
        if (hover(window.getMouse()) && !window.mousePressed()) {
            color = hoverColor;
        } else if (!hover(window.getMouse()) && !window.mousePressed()) {
            color = defaultColor;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRoundRect((int) pos.x, (int) pos.y, (int) dimensions.x, (int) dimensions.y, (int) cornerRoundness, (int) cornerRoundness);
        g.setColor(textColor);
        // Draw centered text
        float fontSize = 0;
        for (int i = 0; i < 150; i++) {
            fontSize = i;
            g.setFont(g.getFont().deriveFont(fontSize));
            if (g.getFontMetrics().stringWidth(text) > dimensions.x * .85) {
                fontSize -= 1;
                break;
            }
        }
        g.setFont(g.getFont().deriveFont(fontSize));

        int textHeight = g.getFontMetrics().getHeight();

        int textX = (int) (pos.x + dimensions.x / 2 - g.getFontMetrics().stringWidth(text) / 2);
        int textY = (int) (pos.y + dimensions.y / 2 + g.getFontMetrics().getHeight() / 2) - textHeight / 4;
        g.drawString(text, textX, textY);
    }

}
