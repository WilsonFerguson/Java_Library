import java.awt.Graphics;

public interface ClickableObject {

    /**
     * Method is called by {@link Window} when the object is clicked.
     */
    public void mouseClicked();

    /**
     * Method is called by {@link Window} when the object is pressed.
     */
    public void mousePressed();

    /**
     * Method is called by {@link Window} when the object is released.
     */
    public void mouseReleased();

    /**
     * Draws the object to the screen given a {@code Graphics} graphics
     * 
     * @param graphics
     */
    public void draw(Graphics graphics);

    /**
     * Method is called by {@link Window} when the object is hovered over.
     * 
     * @param p
     * @return boolean
     */
    public boolean hover(Point p);

    /**
     * Method is called by {@link Window} when the object is hovered over.
     * 
     * @param x
     * @param y
     * @return boolean
     */
    public boolean hover(double x, double y);
}
