public class ExampleItem extends Item {

    public ExampleItem(int quantity, int maxQuantity, String name, String description) {
        super(quantity, maxQuantity, name, description);
    }

    /**
     * Increases the quantity of the item by one.
     */
    public void increaseQuantity() {
        setQuantity(getQuantity() + 1);
    }
    
}