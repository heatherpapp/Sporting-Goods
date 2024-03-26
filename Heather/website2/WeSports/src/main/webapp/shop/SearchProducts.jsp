<%--
    Class: CIST2373 Java Programming 3
    Term: Spring 2024
    Instructor: Chris Bishop
    Description: Solution to Lab     Author: Heather Papp
    I wrote this code myself...
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="website.wesports.Business.Product" %>
<html>
<head>
    <title>Title</title>
    <link rel="apple-touch-icon" sizes="180x180" href="resources/favicon_package_v0.16/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="resources/favicon_package_v0.16/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="resources/favicon_package_v0.16/favicon-16x16.png">
    <link rel="manifest" href="resources/favicon_package_v0.16/site.webmanifest">
    <link rel="mask-icon" href="resources/favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <link rel="stylesheet" href="resources/css/styles.css">
    <link rel="stylesheet" href="resources/css/Preloader.css">
    <script src="https://kit.fontawesome.com/5b6c8cdace.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <nav>
        <a href="Home.html">
            <img src="resources/pictures/clearw.png" class="logo" alt="WeSportsLogo">
        </a>
        <ul>

            <div class="dropdown">
                <button>Shop by Sport</button>
                <div class="dropdown-content">
                    <a href="shop/sports/Baseball.html">Baseball</a>
                    <a href="shop/sports/Basketball.html">Basketball</a>
                    <a href="shop/sports/Cycling.html">Cycling</a>
                    <a href="shop/sports/Football.html">Football</a>
                    <a href="shop/sports/Golf.html">Golf</a>
                    <a href="shop/sports/Running.html">Running</a>
                    <a href="shop/sports/Soccer.html">Soccer</a>
                    <a href="shop/sports/Tennis.html">Tennis</a>
                    <a href="shop/sports/Volleyball.html">Volleyball</a>
                </div>
            </div>
            <div class="dropdown">
                <button>Shop Outdoors</button>
                <div class="dropdown-content">
                    <a href="shop/outdoors/Camping.html">Camping</a>
                    <a href="shop/outdoors/Climbing.html">Climbing</a>
                    <a href="shop/outdoors/Fishing.html">Fishing</a>
                    <a href="shop/outdoors/Kayaking.html">Kayaking</a>
                </div>
            </div>
            <div class="dropdown">
                <button>Shop by Apparel</button>
                <div class="dropdown-content">
                    <a href="shop/apparel/Mens.html">Men's</a>
                    <a href="shop/apparel/Women.html">Women's</a>
                    <a href="shop/apparel/Junior.html">Junior's</a>
                    <a href="shop/apparel/Youth.html">Youth</a>
                </div>
            </div>


        </ul>
        <a href="CustomerLogin.jsp" class="login-button">Login</a>

        <a href="shop/Cart.html" class="btn">
            <i class="fa-solid fa-cart-shopping"></i> Cart
        </a>
    </nav>
</div>

<div class="content">
    <h1>We sports</h1>
    <h4>We do Sports</h4>
    <p>Shop with us today and save!</p>
</div>
<div class="search-container">
    <input type="text" id="search-input" placeholder="Search...">
    <button id="search-button" onclick="search()">Search</button>
</div>


    <!-- NEEDS WORK -->



<h1>Search Results</h1>
    <table>
        <tr>
            <td>Product Code</td>
            <td>Product Name</td>
            <td>Unit Price</td>
            <td>Product Image</td>
        </tr>
        <%
            /**TODO:
             * make search work!!!
             */

            try{
                connection = DriverManager.getConnection(connectionUrl+database, userid, password);
                statement=connection.createStatement();
                String sql ="SELECT * FROM Products WHERE ProductCode="+ProductCode+ ProductName="+roll_no+"' ";
                resultSet = statement.executeQuery(sql);
                while(resultSet.next()){

        %>

        <tr>
            <td><%=resultSet.getString("name") %></td>
            <td><%=resultSet.getString("email") %></td>
            <td><%=resultSet.getString("roll_no") %></td>
        </tr>
        <%
                }
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </table>









<footer class="footer">
    <p>We Sports</p>
    <nav>
        <ul>
            <li><a href="shop/about.html">About us</a></li>
            <li><a href="shop/contact.html">Contact us</a></li>
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
    <iframe hidden width="560" height="315" src="https://www.youtube.com/embed/pc40bGyfikg?si=eWfDv5scQnhxoz5q" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
    <iframe hidden width="560" height="315" src="https://www.youtube.com/embed/pc40bGyfikg?si=eWfDv5scQnhxoz5q" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
    <iframe hidden width="560" height="315" src="https://www.youtube.com/embed/pc40bGyfikg?si=eWfDv5scQnhxoz5q" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

</footer>

<script src="resources/JavaScript/script.js"></script>
</body>
</html>