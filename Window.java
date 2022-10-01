import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Window {
    private JFrame window;
    private int width;
    private int height;
    private String title;

    private boolean mousePressed;
    private int mouseX;
    private int mouseY;

    private Color backgroundColor;

    private ArrayList<JPanel> panels = new ArrayList<JPanel>();
    private ArrayList<ClickableObject> clickableObjects = new ArrayList<ClickableObject>();

    private String key = "";
    private int keyCode = -1;
    private boolean keyJustReleased = false;
    private boolean keyJustPressed = false;

    private boolean mouseClicked = false;

    private double upTime;
    private double startTime;
    private double deltaTime;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;

        createWindow();

        startTime = System.currentTimeMillis();
        upTime = System.currentTimeMillis();
        deltaTime = 0;
    }

    public Window(int width, int height) {
        this(width, height, "");
    }

    public void createWindow() {
        window = new JFrame(title);
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setVisible(true);
        window.setResizable(false);

        backgroundColor = window.getContentPane().getBackground();

        window.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (!mousePressed)
                    mouseClicked = true;
                mousePressed = true;
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (mousePressed)
                    callMethod("mouseReleased");
                mousePressed = false;
            }
        });

        window.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                key = String.valueOf(evt.getKeyChar());
                keyCode = evt.getKeyCode();
                keyJustPressed = true;

                int[] keyCodes = { 8, 10, 16, 17, 18, 27, 32, 37, 38, 39, 40, 112, 113, 114, 115, 116, 117, 118, 119,
                        120, 121, 122, 123 };
                String[] keys = { "Backspace", "Enter", "Shift", "Control", "Alt", "Escape", "Space", "Left", "Up",
                        "Right", "Down", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12" };
                for (int i = 0; i < keyCodes.length; i++) {
                    if (keyCode == keyCodes[i]) {
                        key = keys[i];
                        break;
                    }
                }
            }

            public void keyReleased(KeyEvent evt) {
                keyJustReleased = true;
            }
        });
    }

    public void callMethod(String methodName) {
        try {
            Class<?> c = Class.forName("ClickableObject");
            Method method = c.getDeclaredMethod(methodName);
            for (int i = 0; i < clickableObjects.size(); i++) {
                if (clickableObjects.get(i).hover(mouseX, mouseY)) {
                    method.invoke(clickableObjects.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JFrame getWindow() {
        return window;
    }

    public Graphics getGraphics() {
        return window.getGraphics();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }

    public void setFullscreen() {
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void background(Color color) {
        window.getContentPane().setBackground(color);
        backgroundColor = color;
    }

    public void background(int r, int g, int b) {
        background(new Color(r, g, b));
    }

    public void background(int gray) {
        background(gray, gray, gray);
    }

    private JPanel drawPanels() {
        return new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(backgroundColor);
                // Draw all the panels
                for (int i = 0; i < panels.size(); i++) {
                    JPanel panel = panels.get(i);
                    if (panel instanceof Line) {
                        Line.draw(g, panel);
                    } else if (panel instanceof Rectangle) {
                        Rectangle.draw(g, panel);
                    } else if (panel instanceof Shape) {
                        Shape.draw(g, panel);
                    } else if (panel instanceof Circle) {
                        Circle.draw(g, panel);
                    } else if (panel instanceof Triangle) {
                        Triangle.draw(g, panel);
                    } else if (panel instanceof Text) {
                        Text.draw(g, panel);
                    }
                }

                // Draw the clickable objects
                for (int i = 0; i < clickableObjects.size(); i++) {
                    clickableObjects.get(i).draw(g);
                }
            }
        };
    }

    public void draw() {

        JPanel panel = drawPanels();
        window.add(panel);

        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    window.repaint();
                }
            });
        } catch (InvocationTargetException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void displayFramerate() {
        double fps = getFrameRate();
        Rectangle rectangle = new Rectangle(width - 100, 0, 100, 20);
        rectangle.color(0, 0, 0);
        Text text = new Text(Helper.roundString(fps, 0), width - 700, 10);
        text.color(255, 255, 255);
        text.setFontSize(20);
        add(rectangle);
        add(text);
    }

    public void handleInputs() {
        try {
            mouseX = window.getMousePosition().x;
            mouseY = window.getMousePosition().y;
            mouseX -= 6;
            mouseY -= 30;
        } catch (Exception e) {
            // Do nothing
        }

        if (keyJustReleased) {
            key = "";
            keyCode = -1;
        }
        keyJustReleased = false;
        keyJustPressed = false;

        if (mousePressed)
            callMethod("mousePressed");

        if (mouseClicked)
            callMethod("mouseClicked");

        mouseClicked = false;

    }

    public void update() {
        handleInputs();

        deltaTime = System.currentTimeMillis() - upTime;
        upTime = System.currentTimeMillis();

        draw();

        panels.clear();
        clickableObjects.clear();
    }

    public void add(JPanel panel) {
        panels.add(panel);
    }

    public void add(ClickableObject clickableObject) {
        clickableObjects.add(clickableObject);
    }

    public void close() {
        window.dispose();
    }

    public Point getMouse() {
        return new Point(mouseX, mouseY);
    }

    public boolean mousePressed() {
        return mousePressed;
    }

    public boolean mouseReleased() {
        return !mousePressed;
    }

    public boolean keyPressed() {
        return !key.equals("");
    }

    public boolean keyJustReleased() {
        return keyJustReleased;
    }

    public boolean keyJustPressed() {
        return keyJustPressed;
    }

    public String key() {
        return key;
    }

    public int keyCode() {
        return keyCode;
    }

    public double getTimeMillis() {
        return upTime - startTime;
    }

    public double getTimeSeconds() {
        return (upTime / 1000.0) - (startTime / 1000.0);
    }

    public double getDeltaTime() {
        return deltaTime;
    }

    public double getFrameRate() {
        return 1000.0 / deltaTime;
    }
}
