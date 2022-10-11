import java.awt.Color;
import java.util.Random;
import java.awt.event.*;

public class Main implements JavaLibrary {

    public static void main(String[] args) {
        // inventoryTest();
        // shopTest();

        int width = 1920;
        int height = 1080;

        Window window = new Window(width, height);
        window.setFullscreen();
        window.background(0);
        window.addListener(new Main());
        // window.setTargetFrameRate(60);

        Shape graph = new Shape();
        graph.color(52, 157, 183);

        for (int i = 0; i < width; i++) {
            graph.addPoint(i, f(i));
        }

        window.add(graph);

        Button button = new Button("Click me!", 50, 50, 200, 100);
        button.defaultColor(255, 0, 0);
        button.hoverColor(150, 0, 0);
        button.pressedColor(100, 0, 0);
        button.textColor(255, 255, 255);
        button.setCornerRoundness(10);
        window.add(button);

        InputBox inputBox = new InputBox(window, 50, 200, 200, 100);
        inputBox.defaultColor(255, 255, 255);
        inputBox.selectedColor(200, 200, 200);
        inputBox.textColor(0, 0, 0);
        inputBox.setPlaceholderText("Type something...");
        inputBox.setCornerRoundness(10);
        window.add(inputBox);

        Graph testGraph = new Graph(500, 100, 500, 500, "Test Graph", "X Axis", "Y Axis");
        testGraph.setCornerRoundness(10);
        testGraph.backgroundColor(Color.white);
        testGraph.lineColor(Color.black);
        testGraph.addPoint(20);
        testGraph.addPoint(30);
        testGraph.addPoint(40);
        testGraph.addPoint(50);
        testGraph.addPoint(60);
        testGraph.addPoint(60);
        testGraph.addPoint(55);
        testGraph.addPoint(50);
        testGraph.addPoint(45);
        testGraph.addPoint(65);
        testGraph.addPoint(70);
        testGraph.addPoint(30);
        testGraph.addPoint(20);
        testGraph.addPoint(10);
        testGraph.addPoint(0);

        window.add(testGraph);

        while (true) {
            window.update();

            window.add(graph);
            window.add(testGraph);

            Point mouse = window.getMouse();

            int x = (int) mouse.x;

            double slope = getSlope(x);

            Point center = new Point(x, f(x));

            Point firstPoint = new Point(-1, -slope);
            firstPoint.setMag(150);
            firstPoint.add(center);

            Point secondPoint = new Point(1, slope);
            secondPoint.setMag(150);
            secondPoint.add(center);

            // Had to do magnitude stuff because when slope was very small, the line would
            // be very small

            Line tangent = new Line(firstPoint, secondPoint);
            tangent.color(135, 163, 123);
            window.add(tangent);

            Circle circle = new Circle(center.x, center.y, 5);
            circle.color(Color.white);
            window.add(circle);

            slope = Math.round(slope * 100.0) / 100.0;

            Text text = new Text("Slope: " + slope, 10, 10);
            text.color(Color.white);
            text.setFontType("Times New Roman");
            text.setFontSize(50);
            window.add(text);

            button.update(window);
            window.add(button);

            inputBox.update(window);
            window.add(inputBox);

            window.displayFramerate();
        }

    }

    public static double getSlope(double x) {
        double h = 0.0001;
        double numerator = f(x + h) - f(x);
        double denominator = h;
        double slope = numerator / denominator;
        return slope;
    }

    public static double f(double x) {
        return Math.sin(x / 100) * 100 + 500;
    }

    public static void shopTest() {
        Shop shop = new Shop(5, 5);

        shop.addItem(ShopItem.createShopItem(5, 15, 45, "Premium Sword", "A sword that is very powerful"));
        shop.addItem(ShopItem.createShopItem(18, 40, "Decent Sword"));
        shop.addItem(ShopItem.createShopItem(12, 15, 45, "Premium Sword", "A sword that is very powerful"));

        // Prints original shop
        shop.print();

        System.out.println();

        // Sort the shop and print it
        shop.sort();
        shop.print();

        System.out.println();

        // Prints the visual shop
        shop.printVisual();

    }

    public static void inventoryTest() {
        Inventory inventory = new Inventory(3, 3);

        Item item = Item.createItem("AHyperion", "Hypixel item");
        inventory.addItem(item);

        inventory.addItem(Item.createItem(64, 100, "CTerminator", "Terminator item"));
        inventory.setItem(Item.createItem(50, 100, "CTerminator", "Terminator item"), 2, 2);
        inventory.addItem(Item.createItem("BTest"));

        inventory.print();

        inventory.sort();

        System.out.println();

        inventory.print();

        for (int i = 0; i < inventory.getWidth(); i++) {
            for (int j = 0; j < inventory.getHeight(); j++) {
                inventory.addItem(Item.createItem(String.valueOf(new Random().nextInt(10000))));
            }
        }

        inventory.removeItem(new Random().nextInt(inventory.getWidth()), new Random().nextInt(inventory.getHeight()));

        inventory.printVisual();
    }

    public void mousePressed(MouseEvent evt) {
    }

    public void mouseClicked(MouseEvent evt) {
    }

    public void mouseReleased(MouseEvent evt) {
    }

    public void mouseDragged(MouseEvent evt) {
        Helper.println("Mouse dragged");
    }

    public void mouseWheelMoved(MouseWheelEvent evt) {
        Helper.println("Mouse wheel moved");
    }

    public void keyPressed(KeyEvent evt) {
    }

    public void keyReleased(KeyEvent evt) {
    }

    public void keyTyped(KeyEvent evt) {
    }

}
