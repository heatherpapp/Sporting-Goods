<!DOCTYPE html>
<%@ page import="website.wesports.Business.Customer" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-with, initial-scale=1.0">
    <title>WeSports | Home</title>
    <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/favicon-16x16.png">
    <link rel="manifest" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/site.webmanifest">
    <link rel="mask-icon" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <script src="https://kit.fontawesome.com/5b6c8cdace.js" crossorigin="anonymous"></script>
    <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"> -->
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Preloader.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/customerProfile.css">
 </head>
 <body>
 <div id="preloader">
 </div>
 <div class="container">
     <nav>
         <a href="${pageContext.request.contextPath}/shop/Home.jsp">
             <img src="${pageContext.request.contextPath}/resources/pictures/clearw.png" class="logo" alt="WeSports logo">
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

         <!-- START login/customer buttons -->
         <%
             try {
                 // Logged in Customer
                 Customer c1 = (Customer) session.getAttribute("c1");
                 c1.display();
                 if (c1.Exists) {
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
         <%
             }
         }
         catch (Exception e) {
         %>
         <a href="${pageContext.request.contextPath}/customer/CustomerLogin.jsp" class="login-button">Login</a>
         <a href="${pageContext.request.contextPath}/shop/Cart.html" class="btn">
             <i class="fa-solid fa-cart-shopping"></i> Cart
         </a>
         <%

             }

         %>
         <!-- END login/customer buttons -->

    </nav>

    <div class="content">
        <h1>WeSports</h1>
        <h4>We Do Sports</h4>
        <p>Shop with us today and save!</p>
    </div>

     <div class="search-container">
         <form action="../SearchServlet" method="get">
             <input type="text" id="search-input" name="query" placeholder="Search...">
             <button id="search-button" onclick="search()">Search</button>  <!-- search products for input text -->
         </form>
     </div>

    <!-- Need to Center cards on page-->
    <div class="card">
        <a href="${pageContext.request.contextPath}/shop/Sports.jsp">
            <img src="${pageContext.request.contextPath}/resources/pictures/MultipleSports.jpg" alt="Sporting Equipment">
            <button>Shop Sports</button>
        </a>
    </div>
    <div class="card">
        <a href="${pageContext.request.contextPath}/shop/Outdoors.jsp">
            <img src="${pageContext.request.contextPath}/resources/pictures/outdoor.jpeg" alt="Outdoors Image">
            <button>Shop Outdoors</button>
        </a>
    </div>
    <div class="card">
        <a href="${pageContext.request.contextPath}/shop/Apparel.jsp">
            <img src="${pageContext.request.contextPath}/resources/pictures/sportApparel.jpg" alt="People in Sports">
            <button>Shop Apparel</button>
        </a>
    </div>

</div>

    <div id="search-results">
        <!-- Search results will be displayed here -->
    </div>


<footer class="footer">
    <p>WeSports</p>
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/shop/about.jsp">About Us</a></li>
            <li><a href="${pageContext.request.contextPath}/shop/contact.jsp">Contact Us</a></li>
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

<script>
    var loader = document.getElementById("preloader");
    window.addEventListener("load", function(){
        loader.style.display = "none";
    });
</script>

 <!--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script> -->
 <script src="${pageContext.request.contextPath}/resources/JavaScript/script.js"></script>
 </body>

 </html>