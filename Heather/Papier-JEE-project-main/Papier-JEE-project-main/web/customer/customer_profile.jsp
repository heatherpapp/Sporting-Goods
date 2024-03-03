<%@page contentType="text/html" pageEncoding="UTF-8" import="Papier.Customer"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Customer Orders</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../css/customer_profile.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<jsp:useBean class="Papier.Customer" id="c1" scope="session" />
<% if (c1 == null) 
    c1.selectDB("guest"); %>
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>Account</h4>
      <ul class="nav nav-pills nav-stacked">
        <li> <a href="http://localhost:8080/Papier/index.html">Home Page</a></li>
        <li class="active"> <a href="customer_profile.jsp">Profile</a></li>
        <li> <a href="http://localhost:8080/Papier/customer/customer_orders.jsp">Orders</a></li>
        <li> <A href="http://localhost:8080/Papier/shop/products.jsp">Shop</A>
        <li> <a href="http://localhost:8080/Papier/customer/customer_change.jsp">Update Profile</a></li> 
      </ul><br>
    </div>

    <div class="col-sm-9">
      <h2><span class="glyphicon glyphicon-user"></span> Profile</h2>
      <hr>
      <h5>First Name: <% out.println(c1.getFname()); %> </h5>
      <h5>Last Name: <% out.println(c1.getLname()); %> </h5>
      <h5>Username: <% out.println(c1.getUsername()); %> </h5>
      <h5>Email: <% out.println(c1.getEmail()); %> </h5>
      <h5>Address: <% out.println(c1.getStreet()); %> </h5>
      <h5>City: <% out.println(c1.getCity()); %> </h5>
      <h5>State: <% out.println(c1.getState()); %> </h5>
      <h5>Zip Code: <% out.println(c1.getZipcode()); %> </h5>
      
      <br><hr>
      
    </div>
  </div>
</div>

<footer class="container-fluid">
  <p>Footer Text</p>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
