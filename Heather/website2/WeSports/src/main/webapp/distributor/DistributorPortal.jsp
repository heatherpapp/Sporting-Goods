<%@ page import="website.wesports.Business.Customer" %>
<%@ page import="website.wesports.Business.Distributor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WeSports | Distributor</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Distributors.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">

    <style>
        body {
            font-family: 'Inter', sans-serif;
            background-image: url(${pageContext.request.contextPath}/resources/pictures/store.jpg);
            background-repeat: no-repeat;
            background-size: cover;
            background-attachment: fixed;
            background-position: center center;
        }
    </style>
</head>

<body>
<header class="header">
    <div class="header__content">
        <a href="${pageContext.request.contextPath}/Home.html" class="logo">
            <img src="${pageContext.request.contextPath}/resources/pictures/clearw.png" alt="logo" class="logo__img">
        </a>
        <nav class="nav">
            <ul class="nav__list">
                <li class="nav__item">
                    <a href="${pageContext.request.contextPath}/Home.html" class="btn">Log out</a>
                </li>
            </ul>
        </nav>
    </div>
</header>
<h1>Incoming Orders</h1>
<!-- Insert new order info here -->

</body>

</html>
