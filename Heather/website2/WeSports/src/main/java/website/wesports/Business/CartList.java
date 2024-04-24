package website.wesports.Business;

public class CartList {

    public int count = 0;
    public Cart cartArray[] = new Cart[500];

    /************* Constructors *************/
    public CartList() {}

    /************* Methods *************/
    public void addCartItem(Cart cart) {
        cartArray[count] = cart;
        count++;
    }

    public void display() {
        System.out.println("*******");
        for (int i = 0; i < count; i++) {
            cartArray[i].display();
            System.out.println("*******");
        }
    }
}
