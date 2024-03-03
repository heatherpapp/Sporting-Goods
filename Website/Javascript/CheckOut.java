class Checkout {
    public static void processOrder(ShoppingCart cart) {
        System.out.println("Processing order...");
        double total = 0.0;

        for (Product item : cart.getItems()) {
            System.out.println("Item: " + item.getName() + ", Price: $" + item.getPrice());
            total += item.getPrice();
        }

        System.out.println("Total: $" + total);
        System.out.println("Order processed successfully.");
        cart.clearCart();
    }
}