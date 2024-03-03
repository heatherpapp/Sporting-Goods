<%-- 
    Document   : products
    Created on : Oct 18, 2021, 4:12:18 PM
    Author     : Jason Arnold / Kevin Welkner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Papier.ProductList"%>
<%@page import="Papier.Customer"%>
<%@page import="Papier.Product"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Papier</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>

<body>

<div class="jumbotron">
    <div class="container text-center">
        <a href="../index.html"><img src="http://localhost:8080/Papier/pictures/logo.png" alt="Papier Logo" width="200" height="200"></a>
    </div>
</div>

<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="http://localhost:080/Papier/index.html" class="nav-link px-2 link-dark">Home</a></li>
            <li><a href="http://localhost:8080/Papier/shop/products.jsp" class="nav-link px-2 link-secondary">Products</a></li>
            <li><a href="http://localhost:8080/Papier/customer/customer_profile.jsp" class="nav-link px-2 link-dark">Profile</a></li>
            <li><a href="http://localhost:8080/Papier/customer/customer_orders.jsp" class="nav-link px-2 link-dark">Cart</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">About</a></li>
        </ul>

        <div class="col-md-3 text-end">
            <a href="../customer/customer_login.html"><button type="button" class="btn btn-outline-primary me-2">Login</button></a>
            <a href="../customer/customer_register.html"><button type="button" class="btn btn-primary">Sign-up</button></a>
        </div>
    </header>
</div>

<div class="container text-center">
    <h3><u>All Products</u></h3>
</div><br>


<div class="container">
    <jsp:useBean class="Papier.Customer" id="c1" scope="session" />
    <jsp:useBean class="Papier.ProductList" id="cart" scope="session" />
    <% 
        if (c1.getUsername() == "")
        {
            c1.selectDB("guest@guest.com");
        } %>
    <div class="row">

        <!-- Paper -->
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Paper</div>
                <div class="panel-body"><img src="http://localhost:8080/Papier/pictures/paper.jpeg" class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">
                    <form action="http://localhost:8080/Papier/AddToCartServlet" method="post">
                        <input type="text" id="quantity" name="quantity" value="0">
                        <input type="hidden" id="itemNo" name="itemNo" value="1">
                        <input type="hidden" id="userName" name="userName" value="<%=c1.getUsername() %>">
                        <input type="submit" value="Add to Cart">
                    </form>
                </div>
            </div>
        </div>

        <!-- Pencils -->
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Pencils</div>
                <div class="panel-body"><img src="http://localhost:8080/Papier/pictures/pencils.jpeg" class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">
                    <form action="http://localhost:8080/Papier/AddToCartServlet" method="post">
                        <input type="text" id="quantity" name="quantity" value="0">
                        <input type="hidden" id="itemNo" name="itemNo" value="2">
                        <input type="hidden" id="userName" name="userName" value="<%=c1.getUsername() %>">
                        <input type="submit" value="Add to Cart">
                    </form>
                </div>
            </div>
        </div>

        <!-- Pens -->
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Pens</div>
                <div class="panel-body"><img src="http://localhost:8080/Papier/pictures/pens.jpeg" class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">
                    <form action="http://localhost:8080/Papier/AddToCartServlet" method="post">
                        <input type="text" id="quantity" name="quantity" value="0">
                        <input type="hidden" id="itemNo" name="itemNo" value="3">
                        <input type="hidden" id="userName" name="userName" value="<%=c1.getUsername() %>">
                        <input type="submit" value="Add to Cart">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div><br>

<div class="container">
    <div class="row">

        <!-- Notebooks -->
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Notebooks</div>
                <div class="panel-body"><img src="http://localhost:8080/Papier/pictures/notebooks.jpeg" class = "img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">
                    <form action="http://localhost:8080/Papier/AddToCartServlet" method="post">
                        <input type="text" id="quantity" name="quantity" value="0">
                        <input type="hidden" id="itemNo" name="itemNo" value="4">
                        <input type="hidden" id="userName" name="userName" value="<%=c1.getUsername() %>">
                        <input type="submit" value="Add to Cart">
                    </form>
                </div>
            </div>
        </div>

        <!-- Printers -->
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Printers</div>
                <div class="panel-body"><img src="http://localhost:8080/Papier/pictures/printer.jpeg" class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">
                    <form action="http://localhost:8080/Papier/AddToCartServlet" method="post">
                        <input type="text" id="quantity" name="quantity" value="0">
                        <input type="hidden" id="itemNo" name="itemNo" value="5">
                        <input type="hidden" id="userName" name="userName" value="<%=c1.getUsername() %>">
                        <input type="submit" value="Add to Cart">
                    </form>
                </div>
            </div>
        </div>

        <!-- Computers -->
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Computers</div>
                <div class="panel-body"><img src="http://localhost:8080/Papier/pictures/computer.jpeg" class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">
                    <form action="http://localhost:8080/Papier/AddToCartServlet" method="post">
                        <input type="text" id="quantity" name="quantity" value="0">
                        <input type="hidden" id="itemNo" name="itemNo" value="6">
                        <input type="hidden" id="userName" name="userName" value="<%=c1.getUsername() %>">
                        <input type="submit" value="Add to Cart">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div><br><br>
<hr>

<footer class="container-fluid text-center">
    <p>Fulfiller login <a href="fulfiller/fulfiller_login.html">here</a></p>
    <p>Copyright © 2021 Papier Inc. All rights reserved.</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>