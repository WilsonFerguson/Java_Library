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
        if (rounded % 1 == 0)
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

    /**
     * Prints a given {@code Object[]} with spaces in between each element. Prints a new line at the end.
     * 
     * @param args
     */
    public static void printArray(Object[] args) {
        for (Object arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }

    /**
     * Maps a given {@code double} value from one range to another.
     * 
     * @param value
     * @param start1
     * @param stop1
     * @param start2
     * @param stop2
     * @return double
     */
    public static double map(double value, double start1, double stop1, double start2, double stop2) {
        return start2 + (stop2 - start2) * ((value - start1) / (stop1 - start1));
    }

    /**
     * Returns true if the given {@code String} is an integer.
     * @param str
     * @return boolean
     */
    public static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Returns true if the given {@code Object} is an int. Based on {@link #isInt(String)}.
     * @param obj
     * @return
     */
    public static boolean isInt(Object obj) {
        return isInt(obj.toString());
    }

    /**
     * Returns a String representation of the given {@code Object} array. The String will not contain brackets, each element is separated by a space.
     * @param arr
     * @return String
     */
    public static String toString(Object[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if (i < arr.length - 1)
                str += " ";
        }
        return str + "";
    }

    /**
     * Returns true if the given {@code String[]} array contains the given {@code String} element.
     * @param arr
     * @param element
     * @return boolean
     */
    public static boolean contains(String[] arr, String element) {
        for (String str : arr) {
            if (str.equals(element))
                return true;
        }
        return false;
    }
    /**
     * Returns true if the given {@code int[]} array contains the given {@code int} element.
     * @param arr
     * @param element
     * @return boolean
     */
    public static boolean contains(int[] arr, int element) {
        for (int i : arr) {
            if (i == element)
                return true;
        }
        return false;
    }

    /**
     * Returns true if the given {@code double[]} array contains the given {@code double} element.
     * @param arr
     * @param element
     * @return boolean
     */
    public static boolean contains(double[] arr, double element) {
        for (double d : arr) {
            if (d == element)
                return true;
        }
        return false;
    }
}
