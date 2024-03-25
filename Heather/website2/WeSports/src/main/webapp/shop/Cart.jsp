<%@page import="website.wesports.Business.Product"%>
<%@page import="website.wesports.Business.ProductList"%>
<%@page import="website.wesports.Business.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean class="website.wesports.Business.ProductList" id="cart" scope="session"/>
<jsp:useBean class="website.wesports.Business.Customer" id="customer" scope="session"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>WeSports Checkout</title>
</head>
<body>
    <h1>Your Cart</h1>
    <table border="2" class="center">
        <tr><th>Item in Cart</th><th>Quantity</th><th>Price</th></tr>
        <c:forEach var="product" items="${cart.products}">
            <tr>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.quantity}</td>
                <td>$${product.price * product.quantity}</td>
            </tr>
        </c:forEach>
        <tr><td></td><td></td><td>Total Items</td><td>Total Price</td></tr>
        <tr><td></td><td></td><td>${cart.totalItems}</td><td>$${cart.totalPrice}</td></tr>
    </table><br>
</body>
</html>
