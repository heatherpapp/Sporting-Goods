<%-- 
    Document   : fulfiller_portal
    Created on : Nov 1, 2021, 10:35:44 AM
    Author     : Jason Arnold
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Fulfiller Account</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="../css/fulfiller_portal.css">
</head>
<body>
<jsp:useBean class="Papier.Fulfiller" id="f1" scope="session" />
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav" style="max-width: 8%">
      <h4>Fulfiller Account</h4>
      <ul class="nav nav-pills nav-stacked">
        <li> <a href="http://localhost:8080/Papier/index.html">Home Page</a></li>
        <li class="active"> <a href="fulfiller_portal.html">Portal</a></li>
        <li> <a href="http://localhost:8080/Papier/index.html">Log Out</a></li> 
      </ul><br>
    </div>
      <div class="col-sm-9" style="max-width: 85%; float:right;">
      <h2 ><span class="glyphicon glyphicon-send"></span>  Employee Info</h2>
      <hr>
      <h5>First Name: <% out.println(f1.getFName()); %> </h5>
      <h5>Last Name: <% out.println(f1.getLName()); %></h5>
      <h5>UserName: <% out.println(f1.getUsername()); %></h5>
      <br>
      <form action="http://localhost:8080/Papier/GetOrdersServlet" method="post">
          <input type="submit" value="Get orders">
      </form>
    </div>
  </div>
     
</div>
    
</body>
</html>