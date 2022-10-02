public class Helper {

    /**
     * Returns a {@code double} distance between two points given {@code int} x1,
     * {@code int} y1, {@code int} x2, and {@code int} y2.
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return double
     */
    public static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    /**
     * Returns a {@code double} distance between two points given {@code Point} p1
     * and {@code Point} p2.
     * 
     * @param p1
     * @param p2
     * @return double
     */
    public static double getDistance(Point p1, Point p2) {
        return getDistance(p1.x, p1.y, p2.x, p2.y);
    }

    /**
     * Returns a {@code double} random value between a {@code double} min and
     * {@code double} max.
     * 
     * @param min
     * @param max
     * @return double
     */
    public static double random(double min, double max) {
        return Math.random() * (max - min) + min;
    }

    /**
     * Returns a {@code double} random value between a {@code int} min and
     * {@code int} max.
     * 
     * @param min
     * @param max
     * @return int
     */
    public static int random(int min, int max) {
        return (int) random((double) min, (double) max);
    }

    /**
     * Returns a {@code double} random value between 0 and {@code double} max.
     * 
     * @param max
     * @return double
     */
    public static double random(double max) {
        return random(0, max);
    }

    /**
     * Returns a {@code double} random value between 0 and {@code int} max.
     * 
     * @param max
     * @return int
     */
    public static int random(int max) {
        return random(0, max);
    }

    /**
     * Returns a {@code double} random value between 0 and 1.
     * 
     * @return double
     */
    public static double random() {
        return random(1);
    }

    /**
     * Returns a {@code String} rounded number given a {@code double} number and
     * {@code int} decimal places.
     * 
     * @param num
     * @param places
     * @return String
     */
    public static String roundString(double num, int places) {
        double factor = Math.pow(10, places);
        double rounded = Math.round(num * factor) / factor;
        if (rounded == (int) rounded)
            return Integer.toString((int) rounded);

        return Double.toString(rounded);
    }

    /**
     * Waits a given {@code double} milliseconds. {@code double} milliseconds are
     * converted to {@code long} milliseconds.
     * 
     * @param millis
     */
    public static void wait(double millis) {
        try {
            Thread.sleep((long) millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints every {@code Object} argument given with a space in between. Prints a
     * new line at the end.
     * 
     * @param args
     */
    public static void println(Object... args) {
        for (Object arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }

}
