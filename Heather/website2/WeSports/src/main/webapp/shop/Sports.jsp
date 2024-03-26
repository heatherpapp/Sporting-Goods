<%--
    Document   : Sports.jsp
    Class: CIST 2931 : Advanced Systems Project Management
    Term: Spring 2024
    Instructor: Chris Bishop
    Description: Sports.jsp
    Authors: Heather Papp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="website.wesports.Business.ProductList"%>
<%@page import="website.wesports.Business.Customer"%>
<%@page import="website.wesports.Business.Product"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-with, initial-scale=1.0">
        <title>We Sports | Shop Sports</title>
        <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/favicon_package_v0.16/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/favicon_package_v0.16/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/favicon_package_v0.16/favicon-16x16.png">
        <link rel="manifest" href="${pageContext.request.contextPath}/favicon_package_v0.16/site.webmanifest">
        <link rel="mask-icon" href="${pageContext.request.contextPath}/favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
        <meta name="msapplication-TileColor" content="#da532c">
        <meta name="theme-color" content="#ffffff">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
        <script src="https://kit.fontawesome.com/5b6c8cdace.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <nav>
                <a href="/Website/Home.html">
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
                <a href="${pageContext.request.contextPath}/customer/CustomerLogin.jsp" class="login-button">Login</a>
        
                <a href="${pageContext.request.contextPath}/shop/Cart.html" class="btn">
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
                <a href="${pageContext.request.contextPath}/shop/sports/Baseball.html">
                    <img src="${pageContext.request.contextPath}/pictures/baseball_and_bat.jpg" alt="baseball in a glove next to a bat on the ground">
                    <button>Baseball</button>
                </a>
            </div>
            <div class="card">
                <a href="${pageContext.request.contextPath}/shop/sports/Basketball.html">
                    <img src="${pageContext.request.contextPath}/pictures/basketball_in_net.jpg" alt="basketball in net">
                    <button>Basketball</button>
                </a>
            </div>
            <div class="card">
                <a href="${pageContext.request.contextPath}/shop/sports/Football.html">
                    <img src="${pageContext.request.contextPath}/pictures/football_and_helmet.jpg" alt="football next to helmet on the ground">
                    <button>Football</button>
                </a>
            </div>
            <div class="card">
                <a href="${pageContext.request.contextPath}/shop/sports/Golf.html">
                    <img src="${pageContext.request.contextPath}/pictures/golf_tee_club_hand.jpg" alt="hand placing golf ball on a tee with club">
                    <button>Golf</button>
                </a>
            </div>
            <div class="card">
                <a href="${pageContext.request.contextPath}/shop/sports/Running.html">
                    <img src="${pageContext.request.contextPath}/pictures/running_start.jpg" alt="runner crouched at starting line">
                    <button>Running</button>
                </a>
            </div>
            <div class="card">
                <a href="${pageContext.request.contextPath}/shop/sports/Soccer.html">
                    <img src="${pageContext.request.contextPath}/pictures/soccerball_in_net_score.jpg" alt="soccer ball in net">
                    <button>Soccer</button>
                </a>
            </div>
            <div class="card">
                <a href="${pageContext.request.contextPath}/shop/sports/Tennis.html">
                    <img src="${pageContext.request.contextPath}/pictures/tennis_racquets_balls_net.jpg" alt="tennis rackets leaning against net with balls on the ground">
                    <button>Tennis</button>
                </a>
            </div>
            <div class="card">
                <a href="${pageContext.request.contextPath}/shop/sports/Volleyball.html">
                    <img src="${pageContext.request.contextPath}/pictures/volleyball_hands.jpg" alt="hands lobbing a volleyball">
                    <button>Volleyball</button>
                </a>
            </div>
        </div>

        <footer class="footer">
            <p>We Sports</p>
            <nav>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/shop/about.html">About us</a></li>
                    <li><a href="${pageContext.request.contextPath}/shop/contact.html">Contact us</a></li>
                    <!--<li><a href="thanks.html">Thank you</a></li>Not needed... Intended for contact page. So once they tried to contact us, it linked to a thank you page to acknowledge-->
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
    </body>
</html>