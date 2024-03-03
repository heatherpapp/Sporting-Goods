<%-- 
    Document   : cart
    Created on : Oct 18, 2021, 12:45:39 PM
    Author     : Jason Arnold
--%>

<%@page import="Papier.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="Papier.ProductList" import="Papier.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Profile Change</title>
    </head>
    <body>
        <jsp:useBean class="Papier.ProductList" id="cart" scope="session" />
        <jsp:useBean class="Papier.Customer" id="c1" scope="session" />
        <h1>Your Cart</h1><br>
        <table border="2" class="center">
            <tr><th>Item Name</th><th>Item Description</th><th>Quantity</th><th>Price</th></tr>
            <%  if (c1==null)
                c1.selectDBID("6");
                int totalPrice = 0;
                int totalitems = 0;
                c1.display();
                ProductList order = c1.getOrder();
            for(int i=0; i<cart.count; i++)
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
            <%}%>
            
            <tr><td></td><td></td><td>Total Items</td><td>Total Price</td></tr>
            <tr><td></td><td></td><td><%=totalitems %></td><td>$<%=totalPrice %></td></tr>
            </table><br>
    </body>
</html>
