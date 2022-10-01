import java.util.ArrayList;

public class Shop {
    private int width;
    private int height;
    private ShopItem[][] items;

    public Shop(int width, int height) {
        this.width = width;
        this.height = height;
        items = new ShopItem[width][height];
    }

    /**
     * Sets the item at the specified position.
     * 
     * @param item
     * @param x
     * @param y
     */
    public void setItem(ShopItem item, int x, int y) {
        items[x][y] = item;
    }

    /**
     * Removes the item at the specified position.
     * 
     * @param x
     * @param y
     */
    public void removeItem(int x, int y) {
        items[x][y] = null;
    }

    /**
     * Returns the item at the given x and y coordinates.
     * 
     * @param x The x coordinate of the item you want to get.
     * @param y The y coordinate of the item to get.
     * @return The item at the given x and y coordinates.
     */
    public ShopItem getItem(int x, int y) {
        return items[x][y];
    }

    /**
     * Returns the items in the inventory.
     * 
     * @return The items array.
     */
    public ShopItem[][] getItems() {
        return items;
    }

    /**
     * Returns the width of the inventory.
     * 
     * @return The width of the inventory.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the inventory.
     * 
     * @return The height of the inventory.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Adds the item to the next available slot in the inventory. If no slot is
     * available, it creates a new column
     * and adds the item to the first slot in the new column.
     * 
     * @param item The item to be added to the inventory
     */
    public void addItem(ShopItem item) {
        // Found open spot
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (items[x][y] == null) {
                    items[x][y] = item;
                    return;
                }
            }
        }
        // No spot, add column
        addColumn();
        addItem(item);
    }

    /**
     * Add a new column to the inventory.
     */
    public void addColumn() {
        ShopItem[][] newItems = new ShopItem[width + 1][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                newItems[x][y] = items[x][y];
            }
        }
        items = newItems;
        width++;
    }

    /**
     * Add a new row to the inventory.
     */
    public void addRow() {
        ShopItem[][] newItems = new ShopItem[width][height + 1];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                newItems[x][y] = items[x][y];
            }
        }
        items = newItems;
        height++;
    }

    /**
     * Remove the last column of the inventory.
     */
    public void removeColumn() {
        ShopItem[][] newItems = new ShopItem[width - 1][height];
        for (int x = 0; x < width - 1; x++) {
            for (int y = 0; y < height; y++) {
                newItems[x][y] = items[x][y];
            }
        }
        items = newItems;
        width--;
    }

    /**
     * Remove the last row of the inventory.
     */
    public void removeRow() {
        ShopItem[][] newItems = new ShopItem[width][height - 1];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height - 1; y++) {
                newItems[x][y] = items[x][y];
            }
        }
        items = newItems;
        height--;
    }

    /**
     * Clears the inventory.
     */
    public void clear() {
        items = new ShopItem[width][height];
    }

    /**
     * Prints the inventory. Each item is printed with its quantity, name, and
     * location in the inventory.
     * <p>
     * Example: 3x Example | (2, 0)
     */
    public void print() {
        int longest = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (items[x][y] == null)
                    continue;
                longest = Math.max(items[x][y].getFullName().length(), longest);
            }
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (items[x][y] == null)
                    continue;

                String output = items[x][y].getFullName();
                for (int i = 0; i < longest - items[x][y].getFullName().length() + 1; i++) {
                    output += " ";
                }
                System.out.println(output + "| (" + x + ", " + y + ")");
            }
        }
    }

    /**
     * Prints a visual representation of the inventory in a table.
     */
    public void printVisual() {
        int longestName = 0;
        int[] longestColumn = new int[width];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (items[x][y] != null) {
                    int len = items[x][y].getName().length();
                    if (items[x][y].getName().length() > longestName) {
                        longestName = len;
                    }
                    if (len > longestColumn[x]) {
                        longestColumn[x] = len;
                    }
                }
            }
        }

        int totalColumn = 0;
        for (int i = 0; i < longestColumn.length; i++) {
            totalColumn += longestColumn[i] + 3;
        }

        String topBottomBorder = "";
        for (int i = 0; i < totalColumn + 1; i++) {
            topBottomBorder += "-";
        }

        System.out.println(topBottomBorder);

        for (int y = 0; y < height; y++) {
            System.out.print("| ");
            for (int x = 0; x < width; x++) {
                if (items[x][y] != null) {
                    System.out.print(items[x][y].getName());
                    for (int i = 0; i < longestColumn[x] - items[x][y].getName().length(); i++) {
                        System.out.print(" ");
                    }
                } else {
                    for (int i = 0; i < longestColumn[x]; i++) {
                        System.out.print(" ");
                    }
                }
                if (x < width - 1)
                    System.out.print(" | ");
            }
            System.out.println(" |");
            if (y < height - 1)
                System.out.println(topBottomBorder);
        }

        System.out.println(topBottomBorder);
    }

    /**
     * Sorts the inventory alphabetically by item name. Items with higher quantities
     * go first.
     */
    public void sort() {
        ArrayList<String> uniqueNames = new ArrayList<String>();
        ArrayList<ShopItem> uniqueItems = new ArrayList<ShopItem>();
        ArrayList<ShopItem> finalItems = new ArrayList<ShopItem>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (items[x][y] == null)
                    continue;

                ShopItem item = items[x][y].clone();

                if (!uniqueNames.contains(items[x][y].getName())) {
                    uniqueItems.add(item);
                    uniqueNames.add(items[x][y].getName());
                    continue;
                }

                int index = uniqueNames.indexOf(items[x][y].getName());
                ShopItem newItem = uniqueItems.get(index);
                if (newItem.getQuantity() + items[x][y].getQuantity() > newItem.getMaxQuantity()) {
                    int dif = newItem.getMaxQuantity() - newItem.getQuantity();

                    newItem.setQuantity(newItem.getMaxQuantity());
                    finalItems.add(newItem);

                    // Update uniqueItems
                    items[x][y].setQuantity(items[x][y].getQuantity() - dif);
                    uniqueItems.set(index, items[x][y]);
                    uniqueNames.remove(index); // something isn't working here
                } else {
                    newItem.setQuantity(newItem.getQuantity() + items[x][y].getQuantity());
                    uniqueItems.set(index, newItem);
                }
            }
        }

        clear();

        // Create final array with all items
        ShopItem[] sortedItems = new ShopItem[finalItems.size() + uniqueItems.size()];
        for (int i = 0; i < finalItems.size(); i++) {
            sortedItems[i] = finalItems.get(i);
        }
        for (int i = 0; i < uniqueItems.size(); i++) {
            sortedItems[i + finalItems.size()] = uniqueItems.get(i);
        }

        String[] alph = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                "t", "u", "v", "w", "x", "y", "z" };

        ArrayList<String> alphabet = new ArrayList<String>();
        for (int i = 0; i < alph.length; i++) {
            alphabet.add(alph[i]);
        }

        // Bubble sort
        while (true) {
            boolean done = true;
            for (int i = 0; i < sortedItems.length - 1; i++) {
                ShopItem firstItem = sortedItems[i];
                ShopItem secondItem = sortedItems[i + 1];
                String firstName = firstItem.getName();
                String secondName = secondItem.getName();
                if (firstName.equals(secondName)) {
                    if (firstItem.getQuantity() == secondItem.getQuantity())
                        continue;

                    // Counts aren't equal, but same name
                    if (firstItem.getQuantity() < secondItem.getQuantity())
                        continue; // Sorted correctly

                    sortedItems[i + 1] = firstItem;
                    sortedItems[i] = secondItem;
                    done = false;
                } else {
                    int firstIndex = alphabet.indexOf(firstName.substring(0, 1).toLowerCase());
                    int secondIndex = alphabet.indexOf(secondName.substring(0, 1).toLowerCase());
                    if (firstIndex > secondIndex) {
                        sortedItems[i + 1] = firstItem;
                        sortedItems[i] = secondItem;
                        done = false;
                    }
                }
            }
            if (done)
                break;
        }
        for (int i = 0; i < sortedItems.length; i++) {
            addItem(sortedItems[i]);
        }
    }

    void buy(String name, int quantity) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (items[x][y] == null)
                    continue;
                if (items[x][y].getName().equals(name)) {
                    if (items[x][y].getQuantity() >= quantity) {
                        items[x][y].setQuantity(items[x][y].getQuantity() - quantity);
                        return;
                    } else {
                        items[x][y].setQuantity(0);
                    }
                }
            }
        }
    }

    void buy(String name) {
        buy(name, 1);
    }

    void buy(ShopItem item) {
        buy(item.getName(), 1);
    }

    void buy(ShopItem item, int quantity) {
        buy(item.getName(), quantity);
    }

    void buy(int x, int y, int quantity) {
        if (items[x][y] == null)
            return;

        if (items[x][y].getQuantity() >= quantity) {
            items[x][y].setQuantity(items[x][y].getQuantity() - quantity);
            return;
        } else {
            items[x][y].setQuantity(0);
        }
    }
}