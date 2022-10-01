import java.awt.Graphics;

public interface ClickableObject {
    
    public void mouseClicked();
    public void mousePressed();
    public void mouseReleased();

    public void draw(Graphics g);

    public boolean hover(Point p);
    public boolean hover(double x, double y);
}
