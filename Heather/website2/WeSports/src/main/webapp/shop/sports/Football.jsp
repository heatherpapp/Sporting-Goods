<!DOCTYPE html>
<%@ page import="website.wesports.Business.Customer" %>
<%@ page import="website.wesports.Business.Product" %>
<%@ page import="website.wesports.Business.ProductList" %>
<html>
<head>
    <meta name="viewport" content="width=device-with, initial-scale=1.0">
    <title>WeSports | Shop Sports</title>
    <link rel="apple-touch-icon" sizes="180x180" href="../../resources/favicon_package_v0.16/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../../resources/favicon_package_v0.16/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../../resources/favicon_package_v0.16/favicon-16x16.png">
    <link rel="manifest" href="../../resources/favicon_package_v0.16/site.webmanifest">
    <link rel="mask-icon" href="../../resources/favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="../../resources/css/styles.css">
    <script src="https://kit.fontawesome.com/5b6c8cdace.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <nav>
        <a href="../../Home.html">
            <img src="../../resources/pictures/clearw.png" class="logo">
        </a>
        <ul>

            <div class="dropdown">
                <button>Shop by Sport</button>
                <div class="dropdown-content">

                    <!--Need to Update links to JSP on all-->
                    <a href="../sports/Baseball.jsp">Baseball</a>
                    <a href="../sports/Basketball.jsp">Basketball</a>
                    <a href="../sports/Football.jsp">Football</a>
                    <a href="../sports/Golf.jsp">Golf</a>
                    <a href="../sports/Soccer.jsp">Soccer</a>
                    <a href="../sports/Tennis.jsp">Tennis</a>
                    <a href="../sports/Volleyball.jsp">Volleyball</a>
                </div>
            </div>
            <div class="dropdown">
                <button>Shop Outdoors</button>
                <div class="dropdown-content">
                    <a href="../outdoors/Camping.jsp">Camping</a>
                    <a href="../outdoors/Climbing.jsp">Climbing</a>
                    <a href="../outdoors/Fishing.jsp">Fishing</a>
                    <a href="../outdoors/Kayaking.jsp">Kayaking</a>
                </div>
            </div>
            <div class="dropdown">
                <button>Shop by Apparel</button>
                <div class="dropdown-content">
                    <a href="../apparel/Men.jsp">Men's</a>
                    <a href="../apparel/Women.jsp">Women's</a>
                    <a href="../apparel/Junior.jsp">Junior's</a>
                    <a href="../apparel/Youth.jsp">Youth</a>
                </div>
            </div>

        </ul>
        <a href="../../customer/CustomerLogin.jsp" class="login-button">Login</a>

        <a href="../Cart.html" class="btn">
            <i class="fa-solid fa-cart-shopping"></i> Cart
        </a>
    </nav>

    <div class="content">
        <h1>WeSports</h1>
        <h4>We do Sports</h4>
        <p>Shop with us today and save!</p>
    </div>
    <div class="search-container">
        <form action="../../SearchServlet" method="get">
            <input type="text" id="search-input" name="query" placeholder="Search...">
            <button id="search-button" onclick="search()">Search</button>  <!-- search products for input text -->
        </form>
    </div>


    <div id="search-results">
        <!-- Search results will be displayed here -->
    </div>

    <div class="product">
        <h1>Football Product List</h1>
        <table>
            <thead>
            <tr>
                <th>Picture</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Age Group</th>
                <th>Gender</th>
                <th>Quantity</th>
            </tr>
            </thead>
            <tbody>

            <%
                Product product = new Product();
                product.getDeptProducts("Football");
                //product.display();
                //product.productList.displayList();

                for (Product productItem : product.productList.productArray) {
            %>
            <tr>
                <td><img src="../<%= productItem.getImagePath() %>" width="100" height="100"></td>
                <td><%= productItem.getProductName() %></td>
                <td><%= productItem.getProductDescription() %></td>
                <td><%= productItem.getUnitPrice() %></td>
                <td><%= productItem.getAgeGroup() %></td>
                <td><%= productItem.getGender() %></td>
                <td><%= productItem.getQuantity() %></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>



    </div>

</div>

<footer class="footer">
    <p>WeSports</p>
    <nav>
        <ul>
            <li><a href="../about.html">About Us</a></li>
            <li><a href="../contact.html">Contact Us</a></li>
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

<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script> -->
<script src="../../resources/JavaScript/script.js"></script>
</body>