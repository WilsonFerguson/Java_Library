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
    private double scale;

    /**
     * Creates a new image given a {@code String} path, {@code int} x, {@code int}
     * y, and {@code double} scale.
     * 
     * @param name
     * @param x
     * @param y
     * @param scale
     */
    public WindowImage(String name, int x, int y, double scale) {
        try {
            image = ImageIO.read(new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.x = x;
        this.y = y;
        this.scale = scale;
    }

    /**
     * Paints image to {@code Graph
     * @param graphics
     */
    public void paintComponent(Graphics graphics) {
        graphics.setColor(new Color(0.0f, 0.0f, 0.0f, 0.0f)); // Transparent background
        super.paintComponent(graphics);
        graphics.drawImage(image, x, y, (int) (image.getWidth(null) * scale), (int) (image.getHeight(null) * scale),
                null);
    }

}