<%--
    Document   : Sports.jsp
    Class: CIST 2931 : Advanced Systems Project Management
    Term: Spring 2024
    Instructor: Chris Bishop
    Description: Outdoors.jsp
    Authors: Heather Papp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="website.wesports.Business.ProductList"%>
<%@page import="website.wesports.Business.Customer"%>
<%@page import="website.wesports.Business.Product"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-with, initial-scale=1.0">
        <title>We Sports | Shop Apparel</title>
        <link rel="apple-touch-icon" sizes="180x180" href="/Website/favicon_package_v0.16/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="/Website/favicon_package_v0.16/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="/Website/favicon_package_v0.16/favicon-16x16.png">
        <link rel="manifest" href="/Website/favicon_package_v0.16/site.webmanifest">
        <link rel="mask-icon" href="/Website/favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
        <meta name="msapplication-TileColor" content="#da532c">
        <meta name="theme-color" content="#ffffff">
        <link rel="stylesheet" href="../css/styles.css">
        <script src="https://kit.fontawesome.com/5b6c8cdace.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <nav>
                <a href="../Home.html">
                    <img src="${pageContext.request.contextPath}/pictures/clearw.png" class="logo" alt="WeSportsLogo">
                </a>
                <ul>

                    <div class="dropdown">
                        <button>Shop by Sport</button>
                        <div class="dropdown-content">

                            <!--Need to Update links to JSP on all-->
                            <a href="../sports/Baseball.html">Baseball</a>
                            <a href="../sports/Basketball.html">Basketball</a>
                            <a href="../sports/Cycling.html">Cycling</a>
                            <a href="../sports/Football.html">Football</a>
                            <a href="../sports/Golf.html">Golf</a>
                            <a href="../sports/Running.html">Running</a>
                            <a href="../sports/Soccer.html">Soccer</a>
                            <a href="../sports/Tennis.html">Tennis</a>
                            <a href="../sports/Volleyball.html">Volleyball</a>
                        </div>
                    </div>

                    <div class="dropdown">
                        <button>Shop Outdoors</button>
                        <div class="dropdown-content">
                            <a href="../outdoors/Camping.html">Camping</a>
                            <a href="../outdoors/Climbing.html">Climbing</a>
                            <a href="../outdoors/Fishing.html">Fishing</a>
                            <a href="../outdoors/Kayaking.html">Kayaking</a>
                        </div>
                    </div>

                    <div class="dropdown">
                        <button>Shop by Apparel</button>
                        <div class="dropdown-content">
                            <a href="../apparel/Men.html">Men's</a>
                            <a href="../apparel/Women.html">Women's</a>
                            <a href="../apparel/Junior.html">Junior's</a>
                            <a href="../apparel/Youth.html">Youth</a>
                        </div>
                    </div>

                </ul>
                <a href="Login.html" class="login-button">Login</a>
        
                <a href="/Website/Cart.html" class="btn">
                    <i class="fa-solid fa-cart-shopping"></i> Cart
                </a>
            </nav>
            <div class="content">
                <h1>We sports</h1>
                <h4>We do Sports</h4>
                <p>Shop with us today and save!</p>
            </div>
            <div class="search-container">
                <input type="text" id="search-input" placeholder="Search...">
                <button id="search-button" onclick="search()">Search</button>
            </div>
            

            <div id="search-results">
                <!-- Search results will be displayed here -->
            </div>
            <!-- Need to Center cards on page-->
            <div class="card">
                <a href="/shop/apparel/Men.html">
                    <img src="../pictures/man.jpg" alt="Image 1">
                    <button>Shop Men's Apparel</button>
                </a>
            </div>
            <div class="card">
                <a href="/shop/apparel/Women.html">
                    <img src="../pictures/woman.jpg" alt="Image 1">
                    <button>Shop Women's Apparel</button>
                </a>
            </div>
            <div class="card">
                <a href="/shop/apparel/Junior.html">
                    <img src="../pictures/TeensPlayingSports.jpg" alt="Image 1">
                    <button>Shop Junior Apparel</button>
                </a>
            </div>
            <div class="card">
                <a href="/shop/apparel/Youth.html">
                    <img src="../pictures/Kids.jpeg" alt="Image 1">
                    <button>Shop Youth Apparel</button>
                </a>
            </div>

        <footer class="footer">
            <p>We Sports</p>
            <nav>
                <ul>
                    <li><a href="about.html">About us</a></li>
                    <li><a href="contact.html">Contact us</a></li>
                    <li><a href="thanks.html">Thank you</a></li>
                </ul>
            </nav>
            <p class="website__rights">&copy; Wesports 2024. All rights reserved.</p>
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
    </body>
</html>