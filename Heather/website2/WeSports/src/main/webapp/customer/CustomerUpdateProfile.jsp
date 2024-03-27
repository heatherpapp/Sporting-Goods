<%--
    Class: CIST2373 Java Programming 3
    Term: Spring 2024
    Instructor: Chris Bishop
    Description: Solution to Lab     Author: Heather Papp
    I wrote this code myself...
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WeSports | Customer Portal | Update Profile</title>
    <link rel="apple-touch-icon" sizes="180x180" href="../resources/favicon_package_v0.16/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../resources/favicon_package_v0.16/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../resources/favicon_package_v0.16/favicon-16x16.png">
    <link rel="manifest" href="../resources/favicon_package_v0.16/site.webmanifest">
    <link rel="mask-icon" href="../resources/favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/styles.css">
    <script src="https://kit.fontawesome.com/5b6c8cdace.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">

</head>

<body>

    <div class="container">
        <nav>
            <a href="../Home.html">
                <img src="../resources/pictures/clearw.png" class="logo">
            </a>
            <ul>

                <div class="dropdown">
                    <button>Shop by Sport</button>
                    <div class="dropdown-content">

                        <!--Need to Update links to JSP on all-->
                        <a href="../shop/sports/Baseball.jsp">Baseball</a>
                        <a href="../shop/sports/Basketball.html">Basketball</a>
                        <a href="../shop/sports/Cycling.html">Cycling</a>
                        <a href="../shop/sports/Football.html">Football</a>
                        <a href="../shop/sports/Golf.html">Golf</a>
                        <a href="../shop/sports/Running.html">Running</a>
                        <a href="../shop/sports/Soccer.html">Soccer</a>
                        <a href="../shop/sports/Tennis.html">Tennis</a>
                        <a href="../shop/sports/Volleyball.html">Volleyball</a>
                    </div>
                </div>
                <div class="dropdown">
                    <button>Shop Outdoors</button>
                    <div class="dropdown-content">
                        <a href="../shop/outdoors/Camping.html">Camping</a>
                        <a href="../shop/outdoors/Climbing.html">Climbing</a>
                        <a href="../shop/outdoors/Fishing.html">Fishing</a>
                        <a href="../shop/outdoors/Kayaking.html">Kayaking</a>
                    </div>
                </div>
                <div class="dropdown">
                    <button>Shop by Apparel</button>
                    <div class="dropdown-content">
                        <a href="../shop/apparel/Mens.html">Men's</a>
                        <a href="../shop/apparel/">Women's</a>
                        <a href="../shop/apparel/">Junior's</a>
                        <a href="../shop/apparel/">Youth</a>
                    </div>
                </div>

            </ul>
            <!-- Customer account options dropdown menu -->
            <div class="customer-dropdown-menu">
                <button>Account</button>
                    <div class="customer-dropdown-content">
                        <a href="CustomerProfile.html">Profile</a>
                        <a href="CustomerUpdateProfile.jsp">Update Account</a>
                        <a href="CustomerOrders.jsp">Your Orders</a>
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

        <div class="content">
            <h1>WeSports</h1>
            <h4>We do Sports</h4>
            <p>Shop with us today and save!</p>
        </div>

        <div class="search-container">
            <input type="text" id="search-input" placeholder="Search...">
            <button id="search-button" onclick="search()">Search</button>  <!-- this needs to call the SearchProducts.jsp instead -->
        </div>
    </div>











    <footer class="footer">
        <p>WeSports</p>
        <nav>
            <ul>
                <li><a href="../shop/about.html">About us</a></li>
                <li><a href="../shop/contact.html">Contact us</a></li>
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
    <script src="../resources/JavaScript/script.js"></script>


<!--
<header class="header">
    <div class="header__content">
        <a href="../Home.html" class="logo">
            <img src="../resources/pictures/clearw.png" alt="logo" class="logo__img">
        </a>
        <nav class="nav">
            <ul class="nav__list">
                <li class="nav__item">
                    <a href="#" class="nav__link">Account Settings</a>
                </li>
                <li class="nav__item">
                    <a href="#" class="nav__link">Contact</a>
                </li>
                <li class="nav__item">
                    <a href="#" class="btn">Log out</a>
                </li>
            </ul>
        </nav>
    </div>
</header>

<h1>Order History</h1>
-->
<!-- Insert order history info here -->
</body>
</html>
