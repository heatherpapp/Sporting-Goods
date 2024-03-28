package website.wesports.Business;

/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Ron Enz
 * Description: ProductList Business Object
 * Authors: Heather Papp
 *
 *
 *
 */

import java.sql.*;

/**
 *   Business Object for ProductList
 * @author Heather Papp
 */

public class ProductList {

    public int count = 0;
    public Product productArray[] = new Product[500];

    /************* Constructors *************/
    public ProductList() {}

    /************* Methods *************/
    public void addProducts(Product aProduct) {
        productArray[count] = aProduct;
        count++;
    } // END addProducts()

    public void displayList() {
        System.out.println("=======================================================");
        for(int i = 0; i < count; i++) {
            productArray[i].display();
            System.out.println("-------------------------------------------------------");
        }
    } // END displayList()

    public static void main(String[] args) {
        // for testing only
        ProductList productList = new ProductList();

        Product product = new Product();
        //product.selectPDB("002272904");
        //productList.addProducts(product);

        product.getDeptProducts("Baseball");
        productList.addProducts(product);

    }

    // get product from a specific index
    public Product getProduct(int index) {
        Product aProduct = productArray[index];
        return aProduct;
    }

}
