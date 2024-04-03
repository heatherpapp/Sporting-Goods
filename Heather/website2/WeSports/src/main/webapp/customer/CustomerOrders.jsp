<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="website.wesports.Business.Customer" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <head>
        <meta name="viewport" content="width=device-with, initial-scale=1.0">
        <title>WeSports | Customer Orders</title>
        <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/favicon-16x16.png">
        <link rel="manifest" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/site.webmanifest">
        <link rel="mask-icon" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
        <meta name="msapplication-TileColor" content="#da532c">
        <meta name="theme-color" content="#ffffff">
        <!--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"> -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/CustomerOrders.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/customerProfile.css">

        <script src="https://kit.fontawesome.com/5b6c8cdace.js" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">

    </head>
</head>

<body>
<!-- Navigation -->
<div class="container">
    <nav>
        <a href="${pageContext.request.contextPath}/shop/Home.jsp">
            <img src="${pageContext.request.contextPath}/resources/pictures/clearw.png" class="logo">
        </a>
        <ul>
            <div class="dropdown">
                <button>Shop by Sport</button>
                <div class="dropdown-content">

                    <!--Need to Update links to JSP on all-->
                    <a href="${pageContext.request.contextPath}/shop/sports/Baseball.jsp">Baseball</a>
                    <a href="${pageContext.request.contextPath}/shop/sports/Basketball.jsp">Basketball</a>
                    <a href="${pageContext.request.contextPath}/shop/sports/Football.jsp">Football</a>
                    <a href="${pageContext.request.contextPath}/shop/sports/Golf.jsp">Golf</a>
                    <a href="${pageContext.request.contextPath}/shop/sports/Soccer.jsp">Soccer</a>
                    <a href="${pageContext.request.contextPath}/shop/sports/Tennis.jsp">Tennis</a>
                    <a href="${pageContext.request.contextPath}/shop/sports/Volleyball.jsp">Volleyball</a>
                </div>
            </div>
            <div class="dropdown">
                <button>Shop Outdoors</button>
                <div class="dropdown-content">
                    <a href="${pageContext.request.contextPath}/shop/outdoors/Camping.jsp">Camping</a>
                    <a href="${pageContext.request.contextPath}/shop/outdoors/Climbing.jsp">Climbing</a>
                    <a href="${pageContext.request.contextPath}/shop/outdoors/Fishing.jsp">Fishing</a>
                    <a href="${pageContext.request.contextPath}/shop/outdoors/Kayaking.jsp">Kayaking</a>
                </div>
            </div>
            <div class="dropdown">
                <button>Shop by Apparel</button>
                <div class="dropdown-content">
                    <a href="${pageContext.request.contextPath}/shop/apparel/Men.jsp">Men's</a>
                    <a href="${pageContext.request.contextPath}/shop/apparel/Women.jsp">Women's</a>
                    <a href="${pageContext.request.contextPath}/shop/apparel/Junior.jsp">Junior's</a>
                    <a href="${pageContext.request.contextPath}/shop/apparel/Youth.jsp">Youth</a>
                </div>
            </div>

        </ul>

        <!-- Logged in Customer -->
        <%
            Customer c1 = (Customer) session.getAttribute("c1");
            c1.display();
        %>
        <!-- Customer menu button show account options in dropdown -->
        <div class="customerMenu">
            <button>Account</button>
            <div class="customerMenu-content">
                <a href="${pageContext.request.contextPath}/customer/CustomerProfile.jsp">Account Home</a>
                <a href="${pageContext.request.contextPath}/customer/CustomerUpdateProfile.jsp">Update Account</a>
                <a href="${pageContext.request.contextPath}/customer/CustomerOrders.jsp">Orders</a>
                <a href="${pageContext.request.contextPath}/shop/Help.jsp">Help & FAQs</a>
                <a href="${pageContext.request.contextPath}/customer/CustomerLogout.jsp">Logout</a>
            </div>
        </div>
        <a href="${pageContext.request.contextPath}/shop/Cart.jsp" class="btn">
            <i class="fa-solid fa-cart-shopping"></i> Cart
        </a>

        <!-- other page elements not used here
        <a href="CustomerLogin.jsp" class="login-button">Login</a>
        <a href="../shop/Cart.html" class="btn">
            <i class="fa-solid fa-cart-shopping"></i> Cart
        </a>
        -->
    </nav>
    <!-- Greeting -->
    <div class="content">
        <h1>WeSports</h1>
        <h4>We do Sports</h4>
        <p>Shop with us today and save!</p>
    </div>

    <!-- Search bar
        <div class="search-container">
            <form action="../../SearchServlet" method="get">
                <input type="text" id="search-input" name="query" placeholder="Search...">
                <button id="search-button" onclick="search()">Search</button>
            </form>
        </div>
    -->

    <!-- Page Contents -->


    <br>
    <div class="orderContainer">
        <h1>Pending Orders</h1>
        <table class="orderTable">
            <colgroup>
                <col class="column1"/>
                <col class="column2"/>
                <col class="column3-6"/>
                <col class="column7"/>
            </colgroup>
            <tr>
                <th rowspan="2">Order Number</th>
                <th rowspan="2">Order Date</th>
                <th colspan="5">Order Details</th> <!-- center this across columns -->
            </tr>
            <tr>
                <th>Product Code</th>
                <th>Product Name</th>
                <th>Unit Quantity</th>
                <th>Unit Price</th>
                <th>Unit Subtotal</th>
            </tr>
            <!-- START repeating rows for each order -->
                <tr class="productRow">
                    <td id="getOrderNumber">GET Order Number</td>
                    <td id="getOrderDate">GET Order Date</td>
                    <!-- START repeating rows for each ITEM in order -->
                    <td id="getProductCode">GET Product Code</td>
                    <td id="getProductName">GET Product Name</td>
                    <td id="getQuantityOrdered">GET Unit Quantity</td>
                    <td id="getUnitPrice">GET Unit Price</td>
                    <td id="subtotalUnitsOrdered">GET Unit Subtotal</td>
                    <!-- END repeating rows for each ITEM in order -->
                </tr>
                <tr>
                    <td class="totalRow" colspan="6">GET Order Total</td>
                    <td id="getOrderTotal" class="totalCell">$GET$</td>
                </tr>
                <tr><td colspan="7"><hr></td></tr>
            <!-- END repeating rows for each order -->
        </table>

        <br>
        <hr>
        <br>

        <h1>Completed Orders</h1>
        <table>
            <tr>
                <th>Order Number</th>
                <th>Order Date</th>
                <th>Ship Date</th>
                <th>Order Details</th> <!-- Product Code, Product Name, Quantity, Price -->
                <th>Order Total</th>
            </tr>
            <tr>
                <td></td>
            </tr>
        </table>
    </div>



</div>

<!-- End Page Contents -->



<!-- Footer and Info Links -->
<footer class="footer">
    <p>WeSports</p>
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/shop/about.jsp">About Us</a></li>
            <li><a href="${pageContext.request.contextPath}/shop/contact.jsp">Contact Us</a></li>
        </ul>
    </nav>
    <p class="website__rights">&copy; WeSports 2024. All rights reserved.</p>
    <div class="social__icons">
        <a href="/" class="social__icon--link" target="_blank">
            <i class="fab fa-facebook"></i>
        </a>
        <a href="/" class="social__icon--link" target="_blank">
            <i class="fab fa-instagram"></i>
        </a>
        <a href="/" class="social__icon--link" target="_blank">
            <i class="fab fa-twitter"></i>
        </a>
        <a href="/" class="social__icon--link" target="_blank">
            <i class="fab fa-linkedin"></i>
        </a>
        <a href="/" class="social__icon--link" target="_blank">
            <i class="fab fa-youtube"></i>
        </a>
    </div>
</footer>

<!-- Scripts -->
<!--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"> --></script>
<script src="${pageContext.request.contextPath}/resources/JavaScript/script.js"></script>



</body>
</html>
