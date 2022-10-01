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

    public Text(String text, Point pos, Color color) {
        this.pos = pos;
        this.text = text;
        this.centered = false;
        this.color = color;
    }

    public Text(String text, double x, double y, Color color) {
        this(text, new Point(x, y), color);
    }

    public Text(String text, Point pos, double width) {
        this(text, pos, Color.BLACK);
    }

    public Text(String text, double x, double y, double width) {
        this(text, new Point(x, y), width);
    }

    public Text(String text, Point pos) {
        this(text, pos, 0);
    }

    public Text(String text, double x, double y) {
        this(text, new Point(x, y));
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

    public void setCentered(boolean centered) {
        this.centered = centered;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public void setFontType(String font) {
        this.font = font;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public void setPos(double x, double y) {
        setPos(new Point(x, y));
    }

    public Color getColor() {
        return color;
    }

    public boolean getCentered() {
        return centered;
    }

    public int getFontSize() {
        return fontSize;
    }

    public String getFontType() {
        return font;
    }

    public String getText() {
        return text;
    }

    public Point getPos() {
        return pos.copy();
    }

    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.setFont(new Font(font, Font.PLAIN, fontSize));
        int width = g.getFontMetrics().stringWidth(text);
        int height = g.getFontMetrics().getHeight();
        if (centered) {
            g.drawString(text, (int) (pos.x - width / 2), (int) pos.y + height / 2);
        } else {
            g.drawString(text, (int) pos.x, (int) pos.y + height / 2);
        }
    }

    public static void draw(Graphics g, JPanel panel) {
        Text text = (Text) panel;
        g.setColor(text.getColor());
        g.setFont(new Font(text.getFontType(), Font.PLAIN, text.getFontSize()));
        int textWidth = g.getFontMetrics().stringWidth(text.getText());
        int textHeight = g.getFontMetrics().getHeight();
        if (text.getCentered())
            g.drawString(text.getText(), (int) (text.getPos().x - textWidth / 2), (int) text.getPos().y + textHeight / 2);
        else
            g.drawString(text.getText(), (int) text.getPos().x, (int) text.getPos().y + textHeight / 2);
        
    }

}