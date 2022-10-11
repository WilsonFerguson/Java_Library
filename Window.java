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

    private double upTime;
    private double startTime;
    private double deltaTime;

    private double targetFrameRate = 1000;
    private double sleepTime = 0;
    private double nextGameTick = 0;

    private ArrayList<JavaLibrary> eventListeners = new ArrayList<JavaLibrary>();

    /**
     * Creates a new window given {@code int} width, {@code int} height, and
     * {@code String} title.
     * 
     * @param width
     * @param height
     * @param title
     */
    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;

        createWindow();

        startTime = System.currentTimeMillis();
        upTime = System.currentTimeMillis();
        deltaTime = 0;
    }

    /**
     * Creates a new window given {@code int} width and {@code int} height.
     * 
     * @param width
     * @param height
     */
    public Window(int width, int height) {
        this(width, height, "");
    }

    private void createWindow() {
        window = new JFrame(title);
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setVisible(true);
        window.setResizable(false);

        backgroundColor = window.getContentPane().getBackground();

        window.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                callMethod("mousePressed");
                for (JavaLibrary listener : eventListeners) {
                    listener.mousePressed(evt);
                }
                mousePressed = true;
            }

            public void mouseReleased(MouseEvent evt) {
                callMethod("mouseReleased");
                for (JavaLibrary listener : eventListeners) {
                    listener.mouseReleased(evt);
                }
                mousePressed = false;
            }

            public void mouseClicked(MouseEvent evt) {
                callMethod("mouseClicked");
                for (JavaLibrary listener : eventListeners) {
                    listener.mouseClicked(evt);
                }
            }

            public void mouseDragged(MouseEvent evt) {
                for (JavaLibrary listener : eventListeners) {
                    listener.mouseDragged(evt);
                }
            }

            public void mouseWheelMoved(MouseWheelEvent evt) {
                for (JavaLibrary listener : eventListeners) {
                    listener.mouseWheelMoved(evt);
                }

            }
        });

        window.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                for (JavaLibrary listener : eventListeners) {
                    listener.keyPressed(evt);
                }
            }

            public void keyReleased(KeyEvent evt) {
                for (JavaLibrary listener : eventListeners) {
                    listener.keyReleased(evt);
                }
            }

            public void keyTyped(KeyEvent evt) {
                for (JavaLibrary listener : eventListeners) {
                    listener.keyTyped(evt);
                }
            }
        });
    }

    // Easy way to call a specific method to every ClickableObject in
    // clickableObjects list
    private void callMethod(String methodName) {
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

    /**
     * Returns the {@code JFrame} window.
     * 
     * @return JFrame
     */
    public JFrame getWindow() {
        return window;
    }

    /**
     * Returns the {@code Graphics} graphics of the window.
     * 
     * @return Graphics
     */
    public Graphics getGraphics() {
        return window.getGraphics();
    }

    /**
     * Returns the {@code int} width of the window.
     * 
     * @return int
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the {@code int} height of the window.
     * 
     * @return int
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the {@code String} title of the window.
     * 
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the window to full screen.
     */
    public void setFullscreen() {
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * Sets the background given a {@code Color} color.
     * 
     * @param color
     */
    public void background(Color color) {
        window.getContentPane().setBackground(color);
        backgroundColor = color;
    }

    /**
     * Sets the background given an {@code int} red, {@code int} green, and
     * {@code int} blue.
     * 
     * @param red
     * @param green
     * @param blue
     */
    public void background(int r, int g, int b) {
        background(new Color(r, g, b));
    }

    /**
     * Sets the background given an {@code int} gray.
     * 
     * @param gray
     */
    public void background(int gray) {
        background(gray, gray, gray);
    }

    /**
     * Sets the target frame rate given a {@code double} target frame rate. If the
     * target frame rate is -1, the frame rate is set to 1000.
     * 
     * @param targetFrameRate
     */
    public void setTargetFrameRate(double targetFrameRate) {
        if (targetFrameRate > 0)
            this.targetFrameRate = targetFrameRate;
        else
            this.targetFrameRate = 1000;
    }

    /**
     * Returns the {@code double} target frame rate.
     * 
     * @return double
     */
    public double getTargetFrameRate() {
        return targetFrameRate;
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
                    } else if (panel instanceof Graph) {
                        Graph.draw(g, panel);
                    }
                }

                // Draw the clickable objects
                for (int i = 0; i < clickableObjects.size(); i++) {
                    clickableObjects.get(i).draw(g);
                }
            }
        };
    }

    private void draw() {
        JPanel panel = drawPanels();
        window.add(panel);

        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    SwingUtilities.updateComponentTreeUI(window);
                }
            });
        } catch (InvocationTargetException | InterruptedException e) {
            e.printStackTrace();
        }

        // try {
        // SwingUtilities.invokeAndWait(new Runnable() {
        // public void run() {
        // window.revalidate();
        // window.repaint();
        // }
        // });
        // } catch (InvocationTargetException | InterruptedException e) {
        // e.printStackTrace();
        // }

        // Remove every panel except the one we just added
        for (int i = window.getContentPane().getComponents().length - 1; i > 0; i--) {
            window.getContentPane().remove(i);
        }

    }

    /**
     * Displays the frame rate of the window in the top right corner.
     */
    public void displayFramerate() {
        double fps = getFrameRate();
        Rectangle rectangle = new Rectangle(width - 700, 0, 100, 20);
        rectangle.color(0, 0, 0);
        Text text = new Text(Helper.roundString(fps, 0), width - 700, 10);
        text.color(255, 255, 255);
        text.setFontSize(20);
        add(rectangle);
        add(text);
    }

    private void handleInputs() {
        try {
            mouseX = window.getMousePosition().x;
            mouseY = window.getMousePosition().y;
            mouseX -= 6;
            mouseY -= 30;
        } catch (Exception e) {
            // Do nothing
        }

    }

    private void controlFrameRate() {
        int skipTicks = 1000 / (int) targetFrameRate;

        nextGameTick += skipTicks;
        sleepTime = nextGameTick - getTimeMillis();
        if (sleepTime >= 0)
            Helper.wait(sleepTime);
    }

    /**
     * Updates the window. Must be called at the start of your loop.
     */
    public void update() {
        if (targetFrameRate < 1000)
            controlFrameRate();
        handleInputs();

        deltaTime = System.currentTimeMillis() - upTime;
        upTime = System.currentTimeMillis();

        draw();

        panels.clear();
        clickableObjects.clear();
    }

    /**
     * Adds a {@code JPanel} jpanel to the window.
     * 
     * @param panel
     */
    public void add(JPanel panel) {
        panels.add(panel);
    }

    /**
     * Adds a {@code ClickableObject} clickable object to the window.
     * 
     * @param clickableObject
     */
    public void add(ClickableObject clickableObject) {
        clickableObjects.add(clickableObject);
    }

    /**
     * Adds a {@code JavaLibrary} object to the listeners array so that when a mouse
     * or keyboard input is detected, the corresponding method in the object is
     * called.
     * 
     * @param object
     */
    public void addListener(JavaLibrary object) {
        eventListeners.add(object);
    }

    /**
     * Closes the window.
     */
    public void close() {
        window.dispose();
    }

    /**
     * Returns the {@code Point} mouse position.
     * 
     * @return Point
     */
    public Point getMouse() {
        return new Point(mouseX, mouseY);
    }

    /**
     * Returns true if the mouse is pressed.
     * 
     * @return boolean
     */
    public boolean mousePressed() {
        return mousePressed;
    }

    /**
     * Returns how long the window has been open in {@double} milliseconds.
     * 
     * @return double
     */
    public double getTimeMillis() {
        return upTime - startTime;
    }

    /**
     * Returns how long the window has been open in {@double} seconds.
     * 
     * @return double
     */
    public double getTimeSeconds() {
        return (upTime / 1000.0) - (startTime / 1000.0);
    }

    /**
     * Returns the delta time in {@double} milliseconds.
     * 
     * @return double
     */
    public double getDeltaTime() {
        return deltaTime;
    }

    /**
     * Returns the frame rate of the window in {@double} frames per second.
     * Framerate is capped at 1000 frames per second.
     * 
     * @return double
     */
    public double getFrameRate() {
        return Math.min(1000.0 / deltaTime, 1000); // Cap at 1000
    }
}
