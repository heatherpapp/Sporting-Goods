<%@ page import="website.wesports.Business.Product" %>
<%@ page import="website.wesports.Business.ProductList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="UTF-8">
    <title>Products</title>
</head>
<body>
<h1>All Products</h1>
<table border="1">
    <thead>
    <tr>
        <th>Product Code</th>
        <th>Product Name</th>
        <th>Description</th>
        <th>Unit Price</th>
        <th>Department</th>
        <th>Section</th>
        <th>Age Group</th>
        <th>Gender</th>
        <th>Quantity</th>
    </tr>
    </thead>
    <tbody>
    <%-- Instantiate Product and ProductList objects --%>
    <% Product product = new Product();
        ProductList productList = new ProductList();
        productList = product.getAllProducts(); // Retrieve all products
        for (Product p : productList.getProducts()) { // Loop through products
    %>
    <tr>
        <td><%= p.getProductCode() %></td>
        <td><%= p.getProductName() %></td>
        <td><%= p.getProductDescription() %></td>
        <td><%= p.getUnitPrice() %></td>
        <td><%= p.getDepartment() %></td>
        <td><%= p.getSection() %></td>
        <td><%= p.getAgeGroup() %></td>
        <td><%= p.getGender() %></td>
        <td><%= p.getQuantity() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>


</html>