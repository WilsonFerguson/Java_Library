public class Helper {

    public static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static double getDistance(Point p1, Point p2) {
        return getDistance(p1.x, p1.y, p2.x, p2.y);
    }

    public static double random(double min, double max) {
        return Math.random() * (max - min) + min;
    }

    public static int random(int min, int max) {
        return (int) random((double) min, (double) max);
    }

    public static double random(double max) {
        return random(0, max);
    }

    public static int random(int max) {
        return random(0, max);
    }

    public static double random() {
        return random(1);
    }

    public static String roundString(double num, int places) {
        double factor = Math.pow(10, places);
        return "" + Math.round(num * factor) / factor;
    }

}
