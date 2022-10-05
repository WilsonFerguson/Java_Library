import java.awt.event.*;

public interface JavaLibrary {

    public void mousePressed(MouseEvent evt);

    public void mouseClicked(MouseEvent evt);

    public void mouseReleased(MouseEvent evt);

    public void mouseDragged(MouseEvent evt);

    public void mouseWheelMoved(MouseWheelEvent evt);

    // Keys
    public void keyPressed(KeyEvent evt);

    public void keyReleased(KeyEvent evt);

    public void keyTyped(KeyEvent evt);

}
