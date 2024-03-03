import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();}

    // Add to cart
    public void addItem(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to the cart.");}

    // Remove from cart
    public void removeItem(Product product) {
        items.remove(product);
        System.out.println(product.getName() + " removed from the cart.");}

    // Retrieve Cart
    public List<Product> getItems() {
        return items;}

    // Empty Cart
    public void clearCart() {
        items.clear();
        System.out.println("Cart cleared.");}
}
