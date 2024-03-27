<!DOCTYPE html>
<%@ page import="website.wesports.Business.Customer" %>
<html>
<head>
    <meta name="viewport" content="width=device-with, initial-scale=1.0">
    <title>WeSports | Customer Portal</title>
    <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/favicon-16x16.png">
    <link rel="manifest" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/site.webmanifest">
    <link rel="mask-icon" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/customerProfile.css">
    <script src="https://kit.fontawesome.com/5b6c8cdace.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">

</head>

<body>
<!-- Navigation -->
<div class="container">
    <nav>
        <a href="${pageContext.request.contextPath}/Home.html">
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
        <!-- Customer account options dropdown menu -->

        <div class="customerMenu">
            <button>Account</button>
            <div class="customerMenu-content">
                <a href="CustomerProfile.html">View Account</a>
                <a href="CustomerUpdateProfile.jsp">Update Account</a>
                <a href="CustomerOrders.jsp">Orders</a>
                <a href="${pageContext.request.contextPath}/shop/Help.html">Help & FAQs</a>
                <a href="CustomerLogout.html">Logout</a>
            </div>
        </div>

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

    <!-- Search bar -->
    <div class="search-container">
        <input type="text" id="search-input" placeholder="Search...">
        <button id="search-button" onclick="search()">Search</button>  <!-- this needs to call the SearchProducts.jsp instead -->
    </div>



    <!-- Page Contents -->

    <div>
        <%
            Customer c1 = (Customer) session.getAttribute("c1");
            c1.display();
        %>
        <h1> Welcome, <%=c1.getCustFirstName()%>! </h1> <!-- get customer first name and display here -->

        <ul style="list-style-type: none">
            <li>
                <!-- Display Address Here -->

            </li>
            <li>
                <h4> <a href="CustomerUpdateProfile.jsp">Update Account</a> </h4>
            </li>
            <li>
                <h4> <a href="CustomerOrders.jsp">Orders</a> </h4>
            </li>
            <li>
                <h4> <a href="../shop/Help.html">Help & FAQs</a> </h4>
            </li>
            <li>
                <h4> <a href="CustomerLogout.html">Logout</a> </h4>
            </li>
        </ul>

    </div>

    <!-- End Page Contents -->
</div> <!--End div container -->


<!-- Footer and Info Links -->
<footer class="footer">
    <p>WeSports</p>
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/shop/about.html">About Us</a></li>
            <li><a href="${pageContext.request.contextPath}/shop/contact.html">Contact Us</a></li>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/JavaScript/script.js"></script>



</body>
</html>
