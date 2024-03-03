<%-- 
    Document   : get_orders
    Created on : Nov 1, 2021, 11:42:43 AM
    Author     : Jason Arnold
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.List" import="Papier.Customer" import="Papier.Product" import="Papier.ProductList" import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Customer Orders</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="../css/fulfiller_portal.css">
</head>
<body>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav" style="max-width: 8%">
      <h4>Customer Orders</h4>
      <ul class="nav nav-pills nav-stacked">
        <li> <a href="http://localhost:8080/Papier/index.html">Home Page</a></li>
        <li> <a href="http://localhost:8080/Papier/fulfiller_portal.jsp">Portal</a></li>
        <li class="active"> <a href="http://localhost:8080/Papier/fulfiller/get_orders.jsp">Orders</a></li>
        <li> <a href="LogoutServlet">Log Out</a></li> 
      </ul><br>
    </div>
      <div class="col-sm-9">
          <jsp:useBean class="java.util.ArrayList" id="CustList" scope="session" />
          <%  
                 if (CustList == null)
                     out.println("No Current orders.");
                 else
                 {
                     for (int i=0; i<CustList.size(); i++)
                     {
                         Customer c1 = new Customer();
                         String custId = CustList.get(i).toString();
                         c1.selectDBID(custId);
                     
                  %>
        <h1>Order for:</h1><br>
        <% out.println(c1.getFname() + " " + c1.getLname()); %><br>
        <% out.println(c1.getStreet()); %><br>
        <% out.println(c1.getCity() + ", " + c1.getState() + ", " + c1.getZipcode()); %> <br>
        
        <table border="2" class="center">
            <tr><th>Item Name</th><th>Item Description</th><th>Quantity</th></tr>
            <% ProductList order = new ProductList();
            order = c1.getOrder();
                
            for(int ii=0; ii<order.count; ii++)
            {   
                Product p1 = order.getProduct(ii);
                String name = p1.getName();
                String desc = p1.getDesc();
                String quantity = p1.getQuantity();
            
               %>
            
            <tr>
                <td><% out.println(name); %></td>
                <td><% out.println(desc); %></td>
                <td><% out.println(quantity); %></td>
            </tr>
            <%}%>
</table>
            <form action="http://localhost:8080/Papier/ProcessOrderServlet" method="post">
                <input type="hidden" id="custid" name="custid" value="<% out.println(c1.getId()); %>">
                <input type="submit" value="Process Order">
            </form>
<%}}%>
            
            
        <br><br><br>
        
      
    </div>
  </div>
     
</div>
    
</body>
</html>
