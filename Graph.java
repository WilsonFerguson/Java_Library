import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Graph extends JPanel {
    private ArrayList<Double> yValues = new ArrayList<Double>();

    private Color lineColor = Color.BLACK;
    private Color backgroundColor = Color.WHITE;

    private double cornerRoundness = 0;

    private Point pos;
    private Point dimensions;

    private String title;
    private String xLabel;
    private String yLabel;

    /**
     * Creates a graph with the given {@code Point} position, {@code Point}
     * dimensions, {@code String} title, {@code String} x label, and {@code String}
     * y label.
     * 
     * @param pos
     * @param dimensions
     * @param title
     * @param xLabel
     * @param yLabel
     */
    public Graph(Point pos, Point dimensions, String title, String xLabel, String yLabel) {
        this.pos = pos;
        this.dimensions = dimensions;
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
    }

    /**
     * Creates a graph with the given {@code Point} position, {@code Point}
     * dimensions, and {@code String} title.
     * 
     * @param pos
     * @param dimensions
     * @param title
     */
    public Graph(Point pos, Point dimensions, String title) {
        this(pos, dimensions, title, "", "");
    }

    /**
     * Creates a graph with the given {@code Point} position and {@code Point}
     * dimensions.
     * 
     * @param pos
     * @param dimensions
     */
    public Graph(Point pos, Point dimensions) {
        this(pos, dimensions, "", "", "");
    }

    /**
     * Creates a graph with the given {@code double} x position, {@code double} y
     * position, {@code double} width, {@code double} height, {@code String} title,
     * {@code String} x label, and {@code String} y label.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param title
     * @param xLabel
     * @param yLabel
     */
    public Graph(double x, double y, double width, double height, String title, String xLabel, String yLabel) {
        this(new Point(x, y), new Point(width, height), title, xLabel, yLabel);
    }

    /**
     * Creates a graph with the given {@code double} x position, {@code double} y
     * position, {@code double} width, {@code double} height, and {@code String}
     * title.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param title
     */
    public Graph(double x, double y, double width, double height, String title) {
        this(new Point(x, y), new Point(width, height), title, "", "");
    }

    /**
     * Creates a graph with the given {@code double} x position, {@code double} y
     * position, {@code double} width, and {@code double} height.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Graph(double x, double y, double width, double height) {
        this(new Point(x, y), new Point(width, height), "", "", "");
    }

    /**
     * Adds a {@code double} data point to the graph.
     * 
     * @param dataPoint
     */
    public void addPoint(double dataPoint) {
        yValues.add(dataPoint);
    }

    /**
     * Adds the {@code double} y vaue of a {@code Point} data point to the graph.
     * 
     * @param dataPoint
     */
    public void addPoint(Point dataPoint) {
        yValues.add(dataPoint.y);
    }

    /**
     * Removes the point at the given {@code int} index.
     * 
     * @param index
     */
    public void removeAt(int index) {
        yValues.remove(index);
    }

    /**
     * Removes the given {@code Point} data point.
     * 
     * @param point
     */
    public void removePoint(Point point) {
        yValues.remove(point.y);
    }

    /**
     * Removes the given {@code double} data point.
     * 
     * @param point
     */
    public void removePoint(double point) {
        yValues.remove(point);
    }

    /**
     * Clears all points from the graph.
     */
    public void clear() {
        yValues.clear();
    }

    /**
     * Sets the line color of the graph given a {@code Color} color.
     * 
     * @param color
     */
    public void lineColor(Color color) {
        this.lineColor = color;
    }

    /**
     * Sets the line color of the graph given an {@code int} r, {@code int} g, and
     * {@code int} b.
     * 
     * @param r
     * @param g
     * @param b
     */
    public void lineColor(int r, int g, int b) {
        this.lineColor = new Color(Math.min(r, 255), Math.min(g, 255), Math.min(b, 255));
    }

    /**
     * Sets the line color of the graph given an {@code int} gray.
     * 
     * @param gray
     */
    public void lineColor(int gray) {
        this.lineColor = new Color(gray, gray, gray);
    }

    /**
     * Sets the background color of the graph given a {@code Color} color.
     * 
     * @param color
     */
    public void backgroundColor(Color color) {
        this.backgroundColor = color;
    }

    /**
     * Sets the background color of the graph given an {@code int} r, {@code int} g,
     * and {@code int} b.
     * 
     * @param r
     * @param g
     * @param b
     */
    public void backgroundColor(int r, int g, int b) {
        this.backgroundColor = new Color(Math.min(r, 255), Math.min(g, 255), Math.min(b, 255));
    }

    /**
     * Sets the background color of the graph given an {@code int} gray.
     * 
     * @param gray
     */
    public void backgroundColor(int gray) {
        this.backgroundColor = new Color(gray, gray, gray);
    }

    /**
     * Sets the position of the graph given a {@code Point} position.
     * 
     * @param pos
     */
    public void setPosition(Point pos) {
        this.pos = pos;
    }

    /**
     * Sets the position of the graph given an {@code int} x and {@code int} y.
     * 
     * @param x
     * @param y
     */
    public void setPosition(int x, int y) {
        this.pos = new Point(x, y);
    }

    /**
     * Sets the dimensions of the graph given a {@code Point} dimensions.
     * 
     * @param dimensions
     */
    public void setDimensions(Point dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * Sets the dimensions of the graph given an {@code int} width and {@code int}
     * height.
     * 
     * @param width
     * @param height
     */
    public void setDimensions(int width, int height) {
        this.dimensions = new Point(width, height);
    }

    /**
     * Sets the title of the graph given a {@code String} title.
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the x label of the graph given a {@code String} x label.
     * 
     * @param xLabel
     */
    public void setXLabel(String xLabel) {
        this.xLabel = xLabel;
    }

    /**
     * Sets the y label of the graph given a {@code String} y label.
     * 
     * @param yLabel
     */
    public void setYLabel(String yLabel) {
        this.yLabel = yLabel;
    }

    /**
     * Sets the corner roundness of the graph given a {@code double} corner
     * roundness.
     * 
     * @param cornerRoundness
     */
    public void setCornerRoundness(double cornerRoundness) {
        this.cornerRoundness = cornerRoundness;
    }

    /**
     * Returns the line color of the graph as a {@code Color} color.
     * 
     * @return Color
     */
    public Color getLineColor() {
        return lineColor;
    }

    /**
     * Returns the background color of the graph as a {@code Color} color.
     * 
     * @return Color
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Returns the {@code Point} position of the graph.
     * 
     * @return Point
     */
    public Point getPos() {
        return pos;
    }

    /**
     * Returns the {@code Point} dimensions of the graph.
     * 
     * @return Point
     */
    public Point getDimensions() {
        return dimensions;
    }

    /**
     * Returns the {@code String} title of the graph.
     * 
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the {@code String} x label of the graph.
     * 
     * @return String
     */
    public String getXLabel() {
        return xLabel;
    }

    /**
     * Returns the {@code String} y label of the graph.
     * 
     * @return String
     */
    public String getYLabel() {
        return yLabel;
    }

    /**
     * Returns the highest y value of the graph as a {@code double}.
     * 
     * @return double
     */
    public double getMaxY() {
        double max = 0;
        for (double y : yValues) {
            if (y > max) {
                max = y;
            }
        }
        return max;
    }

    /**
     * Returns the lowest y value of the graph as a {@code double}.
     * 
     * @return double
     */
    public double getMinY() {
        double min = 0;
        for (double y : yValues) {
            if (y < min) {
                min = y;
            }
        }
        return min;
    }

    /**
     * Returns the points in the graph as an {@code ArrayList<Double>} points.
     * 
     * @return ArrayList<Double>
     */
    public ArrayList<Double> getPoints() {
        return yValues;
    }

    /**
     * Returns the points in the graph as an {@code ArrayList<Point>} points. These
     * y values have been mapped, but there is no margin for the for the graph axis
     * or labels.
     * 
     * @return ArrayList<Point>
     */
    public ArrayList<Point> getRawPoints() {
        ArrayList<Point> points = new ArrayList<Point>();
        double gap = dimensions.x / yValues.size();
        double bottom = pos.y + dimensions.y;

        double highest = getMaxY();
        double scale = dimensions.y / highest;

        for (int i = 0; i < yValues.size(); i++) {
            double x = pos.x + (i * gap);
            double y = bottom - (yValues.get(i) * scale);
            points.add(new Point(x, y));
        }
        return points;
    }

    /**
     * Returns the points in the graph as an {@code ArrayList<Point>} points. These
     * y values have been mapped, and there is a margin for the for the graph axis
     * or labels.
     *
     * @return ArrayList<Point>
     */
    public ArrayList<Point> getMappedPoints() {
        ArrayList<Point> points = new ArrayList<Point>();
        double gap = (dimensions.x - 40) / yValues.size();
        double bottom = pos.y + dimensions.y - 20;
        double highest = getMaxY();
        double lowest = getMinY();
        for (int i = 0; i < yValues.size(); i++) {
            double x = pos.x + 20 + (i * gap);
            double y = Helper.map(yValues.get(i), lowest, highest, bottom, pos.y + 20);
            points.add(new Point(x, y));
        }
        return points;
    }

    /**
     * Returns a {@link Shape} object of the graph.
     * 
     * @return Shape
     */
    public Shape toShape() {
        Shape shape = new Shape();
        shape.color(lineColor);

        ArrayList<Point> points = getMappedPoints();
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            shape.addPoint(point.x, point.y);
        }
        return shape;
    }

    /**
     * This method is automatically handled by the {@link Window} class. Paints the
     * graph to a {@code Graphics} graphics.
     * 
     * @param graphics
     */
    public void paintComponent(Graphics graphics) {
        // Rectangle rect = new Rectangle(pos.x, pos.y, dimensions.x, dimensions.y);
        // rect.color(backgroundColor);
        // Rectangle.draw
    }

    /**
     * Static method to draw a graph to {@code Graphics} graphics given a
     * {@code JPanel} panel. This method is automatically handled by the
     * {@link Window} class.
     * 
     * @param graphics
     * @param panel
     */
    public static void draw(Graphics graphics, JPanel panel) {
        Graph graph = (Graph) panel;
        Point pos = graph.getPos();
        Point dimensions = graph.getDimensions();

        // What the y value is when data point is 0
        double heightAt0 = Helper.map(0, graph.getMinY(), graph.getMaxY(), pos.y + dimensions.y - 20, pos.y + 20);

        // Background
        Rectangle rect = new Rectangle(pos.x, pos.y, dimensions.x, dimensions.y);
        rect.color(graph.getBackgroundColor());
        rect.setCornerRoundness(graph.cornerRoundness);
        Rectangle.draw(graphics, rect);

        double width = dimensions.x;
        double height = dimensions.y;

        Color oppColor = new Color(255 - graph.getBackgroundColor().getRed(),
                255 - graph.getBackgroundColor().getGreen(),
                255 - graph.getBackgroundColor().getBlue());

        // Y axis numbers
        graphics.setColor(oppColor);

        // Upper bound label
        String upperBound = String.valueOf(graph.getMaxY());
        if (Helper.isInt(upperBound)) {
            upperBound = upperBound.substring(0, upperBound.indexOf("."));
        } else {
            upperBound = upperBound.substring(0, upperBound.indexOf(".") + 2);
        }
        graphics.drawString(upperBound, (int) pos.x + 5, (int) pos.y + 15);

        // Lower bound label
        String lowerBound = String.valueOf(graph.getMinY());
        if (Helper.isInt(lowerBound)) {
            lowerBound = lowerBound.substring(0, lowerBound.indexOf("."));
        } else {
            lowerBound = lowerBound.substring(0, lowerBound.indexOf(".") + 2);
        }
        graphics.drawString(lowerBound, (int) pos.x + 5, (int) pos.y + (int) height - 5);

        // Line at 0
        if (graph.getMinY() < 0) {
            Line lineAt0 = new Line(pos.x + 20, heightAt0, pos.x + width - 20, heightAt0);
            int bgR = graph.getBackgroundColor().getRed();
            int bgG = graph.getBackgroundColor().getGreen();
            int bgB = graph.getBackgroundColor().getBlue();
            if (bgR < 128) {
                bgR += 50;
            } else {
                bgR -= 50;
            }
            if (bgG < 128) {
                bgG += 50;
            } else {
                bgG -= 50;
            }
            if (bgB < 128) {
                bgB += 50;
            } else {
                bgB -= 50;
            }
            bgR = Math.min(255, Math.max(0, bgR));
            bgG = Math.min(255, Math.max(0, bgG));
            bgB = Math.min(255, Math.max(0, bgB));
            lineAt0.color(new Color(bgR, bgG, bgB));
            Line.draw(graphics, lineAt0);

            // Line at 0 label
            graphics.drawString("0", (int) pos.x + 10, (int) heightAt0 + 5);
        }

        // Axes Lines
        Line xAxis = new Line(pos.x + 20, pos.y + height - 20, pos.x + width - 20, pos.y + height - 20);
        Line yAxis = new Line(pos.x + 20, pos.y + height - 20, pos.x + 20, pos.y + 20);
        xAxis.color(oppColor);
        yAxis.color(oppColor);
        Line.draw(graphics, xAxis);
        Line.draw(graphics, yAxis);

        // Title
        Text title = new Text(graph.getTitle(), pos.x + (width / 2), pos.y + 15);
        title.setCentered(true);
        title.color(oppColor);
        Text.draw(graphics, title);

        // X label
        Text xLabel = new Text(graph.getXLabel(), pos.x + (width / 2), pos.y + height - 13);
        xLabel.setCentered(true);
        xLabel.color(oppColor);
        Text.draw(graphics, xLabel);

        // Y label
        Text yLabel = new Text(graph.getYLabel(), pos.x + 5, pos.y + (height / 2));
        yLabel.setCentered(true);
        yLabel.color(oppColor);
        Text.draw(graphics, yLabel);

        // Draw Points
        Shape shape = graph.toShape();

        Shape.draw(graphics, shape);
    }
}