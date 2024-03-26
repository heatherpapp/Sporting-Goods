<!DOCTYPE html>
<%@ page import="website.wesports.Business.Product" %>
<%@ page import="website.wesports.Business.ProductList" %>
<html>
    <head>
        <meta name="viewport" content="width=device-with, initial-scale=1.0">
        <title>We Sports | Shop Sports</title>
        <link rel="apple-touch-icon" sizes="180x180" href="../../resources/favicon_package_v0.16/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="../../resources/favicon_package_v0.16/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="../../resources/favicon_package_v0.16/favicon-16x16.png">
        <link rel="manifest" href="../../resources/favicon_package_v0.16/site.webmanifest">
        <link rel="mask-icon" href="../../resources/favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
        <meta name="msapplication-TileColor" content="#da532c">
        <meta name="theme-color" content="#ffffff">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
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
                                <a href="../apparel/Mens.html">Men's</a>
                                <a href="../apparel/">Women's</a>
                                <a href="../apparel/">Junior's</a>
                                <a href="../apparel/">Youth</a>
                            </div>
                    </div>

                </ul>
                <a href="../Login.html" class="login-button">Login</a>
        
                <a href="../Cart.html" class="btn">
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
                <button id="search-button" onclick="search()">Search</button>  <!-- this needs to call the SearchProducts.jsp instead -->
            </div>
            

            <div id="search-results">
                <!-- Search results will be displayed here -->
            </div>

            <!--WIP!!!
                for each product where department = baseball show a card with product image, name, and price
                use:
                    Product product = new Product();
                    product.getDeptProducts("Baseball");
            -->

            <div class="product">
                <%
                    Product product = new Product();
                    product.getDeptProducts("Baseball");
                    product.display();
                    product.productList.displayList();


                    try {
                        int c1 = product.productList.count;
                        for (int i = 0; i < c1; i++) {
                            product = product.productList.productArray[i];

                            while (rs.next()) {
                                String name = rs.getString("name");
                                String description = rs.getString("description");
                                double price = rs.getDouble("price");
                                String imageUrl = rs.getString("image_url");

                %>

                <c:forEach items="${imagenames}" var="imagename">
                    <div class="card">
                        <img src="${pageContext.request.contextPath}/images/${imagename}">
                        <h3><%= name %></h3>
                        <p>Description: <%= description %></p>
                        <p>Price: $<%= price %></p>
                        <button>Add to Cart</button>
                    </div>
                </c:forEach>

                <%
                            }
                        }
                    } catch (Exception e) {
                    e.printStackTrace();
                    } finally {
                        if (rs != null) rs.close();
                        if (stmt != null) stmt.close();
                        if (conn != null) conn.close();
                    }
                %>
            </div>
        </div>
        <footer class="footer">
            <p>We Sports</p>
            <nav>
                <ul>
                    <li><a href="../about.html">About us</a></li>
                    <li><a href="../contact.html">Contact us</a></li>
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

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
        <script src="../resources/JavaScript/script.js"></script>
    </body>
</html>