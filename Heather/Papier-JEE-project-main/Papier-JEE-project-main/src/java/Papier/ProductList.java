package Papier;

/**
 * Product List Object 
 * @author Salome
 */
public class ProductList {
    
    
    public int count=0;
    public Product proArr[]=new Product[10];
    
    public void addProducts(Product p1){
        proArr[count]=p1;
        count++;
    }//end addproducts
    
    public void displayList(){
       System.out.println("====================");
       for(int x=0;x<count;x++){
           proArr[x].display(); 
           System.out.println("---------------------");           
       }//end for 
       
       
       
    }//end displayList()
    
    //get product from specific index
       public Product getProduct(int index)
       {
           Product p1 = proArr[index];
        return p1;
       }
    
    public static void main(String args[]){
        
        ProductList plist=new ProductList();
        
        Product a = new Product();
        Product b = new Product();
        Product c = new Product();
        a.selectDB("1");
        b.selectDB("4");
        c.selectDB("3");
        
        plist.addProducts(a);
        plist.addProducts(b);
        plist.addProducts(c);
        
        
        plist.displayList();
        Product p1 = new Product();
        p1 = plist.getProduct(3);
    }

    
}
