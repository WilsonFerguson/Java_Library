import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Color;

public class WindowImage extends JPanel {

    private Image image = null;
    private int x = 0, y = 0;
    private float scale;

    public WindowImage(String name, int x, int y, float scale) {
        try {
            image = ImageIO.read(new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.x = x;
        this.y = y;
        this.scale = scale;
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(0.0f, 0.0f, 0.0f, 0.0f)); // Transparent background
        super.paintComponent(g);
        g.drawImage(image, x, y, (int) (image.getWidth(null) * scale), (int) (image.getHeight(null) * scale), null);
    }

}