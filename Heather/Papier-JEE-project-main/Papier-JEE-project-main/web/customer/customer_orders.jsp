<%-- 
    Document   : customer_orders
    Created on : Oct 18, 2021, 1:44:27 PM
    Author     : Jason Arnold
--%>


<!DOCTYPE html>
<%@page import="Papier.Product"%>
<%@page import="Papier.ProductList"%>
<%@page import="Papier.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
  <title>Customer Orders</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="../css/customer_orders.css">
</head>
<body>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>Orders</h4>
      <ul class="nav nav-pills nav-stacked">
        <li> <a href="http://localhost:8080/Papier/index.html">Home Page</a></li>
        <li> <a href="http://localhost:8080/Papier/customer/customer_profile.jsp">Profile</a></li>
        <li class="active"> <a href="customer_orders.jsp">Orders</a></li>
        <li> <A href="http://localhost:8080/Papier/shop/products.jsp">Shop</A>
        <li> <a href="http://localhost:8080/Papier/LogoutServlet">Log Out</a></li> 
      </ul><br>
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search...">
        <span class="input-group-btn">
          <button class="btn btn-default" type="button">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </span>
      </div>
    </div>

    <div class="col-sm-9">
      
        <jsp:useBean class="Papier.Customer" id="c1" scope="session" />
        <h1>Your Cart</h1><br>
        <table border="2" class="center">
            <tr><th>Item Name</th><th>Item Description</th><th>Quantity</th><th>Price</th></tr>
            <%  int totalPrice = 0;
                int totalitems = 0;
                //c1.display();
                ProductList cart = c1.getCart();
                if (c1.getCart() == null)
                    out.println("No Items in Cart");
                else
                {
                    for(int i=0; i<cart.count; i++)
                    {   
                        Product p1 = cart.getProduct(i);
                        String name = p1.getName();
                        String desc = p1.getDesc();
                        String quantity = p1.getQuantity();
                        Double price = p1.getPrice();
            
                    %>
            
                    <tr>
                        <td><%=name %></td>
                        <td><%=desc %></td>
                        <td><%=quantity %></td>
                        <td>$<%=price * Integer.parseInt(quantity) %></td>
                        <%totalPrice += (price * Integer.parseInt(quantity));%>
                        <%totalitems += Integer.parseInt(quantity);%>
                    </tr>
                    <%}}%>
            
            <tr><td></td><td></td><td>Total Items</td><td>Total Price</td></tr>
            <tr><td></td><td></td><td><%=totalitems %></td><td>$<%=totalPrice %></td></tr>
            
            
        </table><br>
        <form action="http://localhost:8080/Papier/Checkout" mehod="post">
            <input type="hidden" id="userName" name="userName" value="<%=c1.getUsername() %>">
            <button class="w-100 btn btn-lg btn-primary" type="submit" name="placeOrder">Place Order</button>
                
        </form>
                <br><br><br>
        
        <div class="col-sm-9">
      
        <h1>Your Order (Pending Shipment)</h1><br>
        <table border="2" class="center">
            <tr><th>Item Name</th><th>Item Description</th><th>Quantity</th><th>Price</th></tr>
            <%  totalPrice = 0;
                totalitems = 0;
                //c1.display();
                ProductList order = c1.getOrder();
                if (c1.getOrder() == null)
                    out.println("No Current orders.");
                else
                {
            for(int i=0; i<order.count; i++)
            {   
                Product p1 = order.getProduct(i);
                String name = p1.getName();
                String desc = p1.getDesc();
                String quantity = p1.getQuantity();
                Double price = p1.getPrice();
            
               %>
            
            <tr>
                <td><%=name %></td>
                <td><%=desc %></td>
                <td><%=quantity %></td>
                <td>$<%=price * Integer.parseInt(quantity) %></td>
                <%totalPrice += (price * Integer.parseInt(quantity));%>
                <%totalitems += Integer.parseInt(quantity);%>
            </tr>
            <%}}%>
            
            <tr><td></td><td></td><td>Total Items</td><td>Total Price</td></tr>
            <tr><td></td><td></td><td><%=totalitems %></td><td>$<%=totalPrice %></td></tr>
            
        </table><br><br><br>
        
      
    </div>
  </div>
</div>

<footer class="container-fluid">
  <p>Footer Text</p>
</footer>

</body>
</html>
