public class Item {
    private int quantity;
    private int maxQuantity;
    private String name;
    private String description;

    public Item(int quantity, int maxQuantity, String name, String description) {
        this.quantity = quantity;
        this.maxQuantity = maxQuantity;
        this.name = name;
        this.description = description;
    }

    /**
     * Returns how many of that item there are.
     * 
     * @return The quantity of the item.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the maximum quantity of the item.
     * 
     * @return The maximum quantity of the item.
     */
    public int getMaxQuantity() {
        return maxQuantity;
    }

    /**
     * Returns the name of the item.
     * 
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the name of the item with its quantity
     * 
     * @return The name of the item with its quantity
     */
    public String getFullName() {
        return quantity + "x " + name;
    }

    /**
     * Returns the description of the item.
     * 
     * @return The description of the item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the quantity of the item.
     * 
     * @param quantity The new quantity of the item.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the maximum quantity the item can have.
     * 
     * @param maxQuantity The new maximum quantity of the item.
     */
    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    /**
     * Sets the new name of the item.
     * 
     * @param name The new name for the item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the new description of the item.
     * 
     * @param description The new description for the item.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Makes a clone of the item.
     * 
     * @return A new Item object with the same properties as the original.
     */
    public Item clone() {
        return new Item(quantity, maxQuantity, name, description);
    }

    /**
     * Creates a new item.
     * 
     * @param quantity    The amount of the item you have.
     * @param maxQuantity The maximum amount of the item that can be held in the
     *                    inventory.
     * @param name        The name of the item.
     * @param description The description of the item.
     * @return A new Item object.
     */
    public static Item createItem(int quantity, int maxQuantity, String name, String description) {
        return new Item(quantity, maxQuantity, name, description);
    }

    /**
     * Creates a new item.
     * 
     * @param quantity    The amount of the item you want to create.
     * @param name        The name of the item.
     * @param description The description of the item.
     * @return A new Item object.
     */
    public static Item createItem(int quantity, String name, String description) {
        return new Item(quantity, quantity, name, description);
    }

    /**
     * Creates a new item.
     * 
     * @param quantity The amount of the item you want to create.
     * @param name     The name of the item.
     * @return A new Item object.
     */
    public static Item createItem(int quantity, String name) {
        return new Item(quantity, quantity, name, "");
    }

    /**
     * Create a new item.
     * 
     * @param name        The name of the item.
     * @param description The description of the item.
     * @return A new Item object.
     */
    public static Item createItem(String name, String description) {
        return new Item(1, 1, name, description);
    }

    /**
     * Creates a new item.
     * 
     * @param name The name of the item.
     * @return A new Item object.
     */
    public static Item createItem(String name) {
        return new Item(1, 1, name, "");
    }
}