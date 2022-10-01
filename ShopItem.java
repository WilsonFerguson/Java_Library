public class ShopItem {
    private int quantity;
    private int maxQuantity;
    private float price;
    private String name;
    private String description;

    public ShopItem(int quantity, int maxQuantity, float price, String name, String description) {
        this.quantity = quantity;
        this.maxQuantity = maxQuantity;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    /**
     * Returns the quantity of the item.
     * 
     * @return The quantity of the item.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the maximum quantity of the item.
     * 
     * @return The maxQuantity variable is being returned.
     */
    public int getMaxQuantity() {
        return maxQuantity;
    }

    /**
     * Returns the price of the item.
     * 
     * @return The price of the item.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Returns the name of the object.
     * 
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a string containing the quantity and name of the item.
     * Example: "15x Example"
     * 
     * @return The quantity and name of the item.
     */
    public String getFullName() {
        return quantity + "x " + name;
    }

    /**
     * Returns the description of the object
     * 
     * @return The description of the item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the quantity of the item
     * 
     * @param quantity The number of items in the order.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Increases the quantity of a product by a given amount.
     * 
     * @param increase The amount to increase the quantity by.
     */
    public void increaseQuantity(int increase) {
        this.quantity += increase;
    }

    /**
     * Decreases the quantity of the item by a given amount.
     * 
     * @param decrease The amount to decrease the quantity by.
     */
    public void decreaseQuantity(int decrease) {
        this.quantity -= decrease;
    }

    /**
     * Decreases the quantity of the item by one.
     */
    public void decreaseQuantity() {
        this.quantity--;
    }

    /**
     * Sets the maximum quantity of a product
     * 
     * @param maxQuantity The maximum number of items that can be added to the cart.
     */
    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    /**
     * Sets the price of the item
     * 
     * @param price The price of the item.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Multiplies the price by a given amount.
     * 
     * @param multiplier The number to multiply the price by.
     */
    public void multiplyPrice(float multiplier) {
        this.price *= multiplier;
    }

    /**
     * Increases the price by a given amount.
     * 
     * @param increase The amount to increase the price by.
     */
    public void increasePrice(int increase) {
        this.price += increase;
    }

    /**
     * Sets the name of the shop item.
     * 
     * @param name New name for the item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description of the item.
     * 
     * @param description New description for the item.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Makes a clone of the item.
     * 
     * @return A new ShopItem object with the same properties as the original.
     */
    public ShopItem clone() {
        return new ShopItem(quantity, maxQuantity, price, name, description);
    }

    /**
     * Creates a new ShopItem.
     * 
     * @param quantity    The amount of the item the player has.
     * @param maxQuantity The maximum amount of this item that can be bought.
     * @param price       The price of the item
     * @param name        The name of the item.
     * @param description The description of the item.
     * @return A new ShopItem object.
     */
    public static ShopItem createShopItem(int quantity, int maxQuantity, float price, String name, String description) {
        return new ShopItem(quantity, maxQuantity, price, name, description);
    }

    /**
     * Creates a new ShopItem.
     * 
     * @param quantity    The amount of the item the player has.
     * @param maxQuantity The maximum amount of items that can be bought.
     * @param price       The price of the item
     * @param name        The name of the item.
     * @return A new ShopItem object.
     */
    public static ShopItem createShopItem(int quantity, int maxQuantity, float price, String name) {
        return new ShopItem(quantity, maxQuantity, price, name, "");
    }

    /**
     * Creates a new ShopItem.
     * 
     * @param quantity The amount of the item you want to sell
     * @param price    The price of the item
     * @param name     The name of the item.
     * @return A new ShopItem object.
     */
    public static ShopItem createShopItem(int quantity, float price, String name) {
        return new ShopItem(quantity, quantity, price, name, "");
    }

}
