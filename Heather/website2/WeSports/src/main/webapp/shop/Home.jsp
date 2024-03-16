<%@ page import="website.wesports.Business.Product" %>
<%@ page import="website.wesports.Business.ProductList" %>
<%@ page import="website.wesports.Business.Customer" %>
<%@ page import="website.wesports.Business.Distributor" %>
<%@ page import="website.wesports.Business.Orders" %>
<%@ page import="website.wesports.Business.Cart" %>
<html>
<head>
    <meta name="viewport" content="width=device-with, initial-scale=1.0">
    <title>We Sports | Home</title>
    <link rel="apple-touch-icon" sizes="180x180" href="../favicon_package_v0.16/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../favicon_package_v0.16/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../favicon_package_v0.16/favicon-16x16.png">
    <link rel="manifest" href="../favicon_package_v0.16/site.webmanifest">
    <link rel="mask-icon" href="../favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <link rel="stylesheet" href="../css/styles.css">
    <link rel="stylesheet" href="../css/Preloader.css">
    <script src="https://kit.fontawesome.com/5b6c8cdace.js" crossorigin="anonymous"></script>
</head>
<body>
<div id="preloader">
</div>
<div class="container">
    <nav>
        <a href="../shop/Home.html">
            <img src="../pictures/clearw.png" class="logo">
        </a>
        <ul>

            <div class="dropdown">
                <button>Shop by Sport</button>
                <div class="dropdown-content">

                    <!--Need to Update links to JSP on all-->
                    <a href="sports/Baseball.html">Baseball</a>
                    <a href="sports/Basketball.html">Basketball</a>
                    <a href="sports/Cycling.html">Cycling</a>
                    <a href="sports/Football.html">Football</a>
                    <a href="sports/Golf.html">Golf</a>
                    <a href="sports/Running.html">Running</a>
                    <a href="sports/Soccer.html">Soccer</a>
                    <a href="sports/Tennis.html">Tennis</a>
                    <a href="sports/Volleyball.html">Volleyball</a>
                </div>
            </div>
            <div class="dropdown">
                <button>Shop Outdoors</button>
                <div class="dropdown-content">
                    <a href="outdoors/Camping.html">Camping</a>
                    <a href="outdoors/Climbing.html">Climbing</a>
                    <a href="outdoors/Fishing.html">Fishing</a>
                    <a href="outdoors/Kayaking.html">Kayaking</a>
                </div>
            </div>
            <div class="dropdown">
                <button>Shop by Apparel</button>
                <div class="dropdown-content">
                    <a href="apparel/Mens.html">Men's</a>
                    <a href="apparel/Women.html">Women's</a>
                    <a href="apparel/Junior.html">Junior's</a>
                    <a href="apparel/Youth.html">Youth</a>
                </div>
            </div>


        </ul>
        <a href="../customer/CustomerLogin.html" class="login-button">Login</a>

        <a href="../shop/Cart.html" class="btn">
            <i class="fa-solid fa-cart-shopping"></i> Cart
        </a>
    </nav>
    <div class="content">
        <h1>We sports</h1>
        <h4>We do Sports</h4>
        <p>Shop with us today and save!</p>
    </div>
    <div class="search-container">
        <form method="post" action="SearchProducts.jsp">
            <input type="text" id="search-input" placeholder="Search...">
            <button id="search-button" onclick="">Search</button>
        </form>
    </div>

    <!-- Need to Center cards on page-->
    <div class="card">
        <a href="../shop/Sports.html">
            <img src="../pictures/MultipleSports.jpg" alt="Sporting Equipment">
            <button>Shop Sports</button>
        </a>
    </div>
    <div class="card">
        <a href="../shop/Outdoors.html">
            <img src="../pictures/outdoor.jpeg" alt="Image 1">
            <button>Shop Outdoors</button>
        </a>
    </div>
    <div class="card">
        <a href="../shop/Apparel.html">
            <img src="../pictures/sportApparel.jpg" alt="People in Sports">
            <button>Shop Apparel</button>
        </a>
    </div>


    <div class="card">
        <a href="../shop/apparel/Men.html">
            <img src="../pictures/man.jpg" alt="Image 1">
            <button>Shop Men's Apparel</button>
        </a>
    </div>
    <div class="card">
        <a href="../shop/apparel/Women.html">
            <img src="../pictures/woman.jpg" alt="Image 1">
            <button>Shop Women's Apparel</button>
        </a>
    </div>
    <div class="card">
        <a href="../shop/apparel/Junior.html">
            <img src="../pictures/TeensPlayingSports.jpg" alt="Image 1">
            <button>Shop Junior Apparel</button>
        </a>
    </div>
    <div class="card">
        <a href="../shop/apparel/Youth.html">
            <img src="../pictures/Kids.jpeg" alt="Image 1">
            <button>Shop Youth Apparel</button>
        </a>
    </div>

</div>

<div id="search-results">
    <!-- Search results will be displayed here -->
</div>

</div>

<footer class="footer">
    <p>We Sports</p>
    <nav>
        <ul>
            <li><a href="../shop/about.html">About us</a></li>
            <li><a href="../shop/contact.html">Contact us</a></li>
            <!--<li><a href="thanks.html">Thank you</a></li>Not needed... Intended for contact page. So once they tried to contact us, it linked to a thank you page to acknowledge-->
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


<script src="../JavaScript/script.js"></script>
</body>

</html>