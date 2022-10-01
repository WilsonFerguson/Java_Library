import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class InputBox implements ClickableObject {

    private Point pos, dimensions;

    private Color color;
    private Color defaultColor;
    private Color selectedColor;
    private Color textColor;

    private String placeholderText;
    private String text;

    private double cornerRoundness;

    private boolean selected;

    public InputBox(Point pos, Point dimensions) {
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
    }

    public InputBox(double x, double y, double width, double height) {
        this(new Point(x, y), new Point(width, height));
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public void setPos(double x, double y) {
        setPos(new Point(x, y));
    }

    public void setDimensions(Point dimensions) {
        this.dimensions = dimensions;
    }

    public void setDimensions(double width, double height) {
        setDimensions(new Point(width, height));
    }

    public void color(Color color) {
        this.color = color;
    }

    public void color(int r, int g, int b) {
        color(new Color(r, g, b));
    }

    public void color(int gray) {
        color(gray, gray, gray);
    }

    public void defaultColor(Color color) {
        defaultColor = color;
    }

    public void defaultColor(int r, int g, int b) {
        defaultColor(new Color(r, g, b));
    }

    public void defaultColor(int gray) {
        defaultColor(gray, gray, gray);
    }

    public void selectedColor(Color color) {
        selectedColor = color;
    }

    public void selectedColor(int r, int g, int b) {
        selectedColor(new Color(r, g, b));
    }

    public void selectedColor(int gray) {
        selectedColor(gray, gray, gray);
    }

    public void textColor(Color color) {
        textColor = color;
    }

    public void textColor(int r, int g, int b) {
        textColor(new Color(r, g, b));
    }

    public void textColor(int gray) {
        textColor(gray, gray, gray);
    }

    public void setPlaceholderText(String placeholderText) {
        this.placeholderText = placeholderText;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCornerRoundness(double cornerRoundness) {
        this.cornerRoundness = cornerRoundness;
    }

    public void selected(boolean selected) {
        this.selected = selected;
    }

    public Point getPos() {
        return pos;
    }

    public Point getDimensions() {
        return dimensions;
    }

    public Color getColor() {
        return color;
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public String getPlaceholderText() {
        return placeholderText;
    }

    public String getText() {
        return text;
    }

    public double getCornerRoundness() {
        return cornerRoundness;
    }

    public boolean isSelected() {
        return selected;
    }

    public void mouseClicked() {
    }

    public void mousePressed() {
        selected = true;
        color = selectedColor;
    }

    public void mouseReleased() {
    }

    public void update(Window window) {
        if (window.mousePressed() && !hover(window.getMouse())) {
            selected = false;
            color = defaultColor;
        }

        String key = window.key();
        boolean keyPressed = window.keyJustPressed();
        if (!keyPressed)
            return;
        
        if (key.equals("Escape")) {
            selected = false;
            color = defaultColor;
            return;
        }
        if (selected && key != "") {
            if (key.equals("Backspace")) {
                if (text.length() > 0) {
                    text = text.substring(0, text.length() - 1);
                }
            } else if (key.equals("Space")) {
                text += " ";
            } else if (key.length() == 1) {
                text += key;
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRoundRect((int) pos.getX(), (int) pos.getY(), (int) dimensions.getX(), (int) dimensions.getY(),
                (int) cornerRoundness, (int) cornerRoundness);

        if (text.equals(""))
            g.setColor(new Color(200, 200, 200));
        else
            g.setColor(textColor);
        g.setFont(new Font("Arial", Font.PLAIN, 17));
        int textHeight = g.getFontMetrics().getHeight();
        int textY = (int) (pos.y + dimensions.y / 2 + textHeight / 2) - textHeight / 4;

        if (text.equals("")) {
            g.drawString(placeholderText, (int) pos.getX() + 5, textY);
        } else {
            g.drawString(text, (int) pos.getX() + 5, textY);
        }
    }

    public boolean hover(Point p) {
        double pX = p.x;
        double pY = p.y;
        return pos.x <= pX && pX <= pos.x + dimensions.x && pos.y <= pY && pY <= pos.y + dimensions.y;
    }

    public boolean hover(double x, double y) {
        return hover(new Point(x, y));
    }

}
