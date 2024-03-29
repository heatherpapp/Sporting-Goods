<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="website.wesports.Business.Product" %>
<%@ page import="website.wesports.Business.Customer" %>
<html>
<head>
    <title>Title</title>
    <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/favicon-16x16.png">
    <link rel="manifest" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/site.webmanifest">
    <link rel="mask-icon" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Preloader.css">
    <script src="https://kit.fontawesome.com/5b6c8cdace.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <nav>
        <a href="${pageContext.request.contextPath}/shop/Home.jsp">
            <img src="${pageContext.request.contextPath}/resources/pictures/clearw.png" class="logo" alt="WeSportsLogo">
        </a>
        <ul>

            <div class="dropdown">
                <button>Shop by Sport</button>
                <div class="dropdown-content">
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
        <a href="${pageContext.request.contextPath}/customer/CustomerLogin.jsp" class="login-button">Login</a>
        <!-- Logged in Customer -->
        <%
            Customer c1 = (Customer) session.getAttribute("c1");
            c1.display();
        %>
        <a href="${pageContext.request.contextPath}/shop/Cart.jsp" class="btn">
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
    <iframe hidden width="560" height="315" src="https://www.youtube.com/embed/pc40bGyfikg?si=eWfDv5scQnhxoz5q" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
    <iframe hidden width="560" height="315" src="https://www.youtube.com/embed/pc40bGyfikg?si=eWfDv5scQnhxoz5q" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
    <iframe hidden width="560" height="315" src="https://www.youtube.com/embed/pc40bGyfikg?si=eWfDv5scQnhxoz5q" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

</footer>

<script src="${pageContext.request.contextPath}/resources/JavaScript/script.js"></script>
</body>
</html>