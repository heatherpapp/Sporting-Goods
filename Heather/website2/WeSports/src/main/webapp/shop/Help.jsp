<!DOCTYPE html>
<%@ page import="website.wesports.Business.Customer" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-with, initial-scale=1.0">
    <title>Help & FAQs</title>
    <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/favicon-16x16.png">
    <link rel="manifest" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/site.webmanifest">
    <link rel="mask-icon" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <script src="https://kit.fontawesome.com/5b6c8cdace.js" crossorigin="anonymous"></script>
    <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/help.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Preloader.css">
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
        <a href="${pageContext.request.contextPath}/shop/Cart.jsp" class="btn">
            <i class="fa-solid fa-cart-shopping"></i> Cart
        </a>
        <%

            }

        %>
        <!-- END login/customer buttons -->

    </nav>

    <div class="search-container">
        <form action="../SearchServlet" method="get">
            <input type="text" id="search-input" name="query" placeholder="Search...">
            <button id="search-button" onclick="search()">Search</button>  <!-- search products for input text -->
        </form>
    </div>

    <div class="faqCard">
        FAQ
    </div>

    <button class="accordion">What payment methods do you accept?</button>
    <div class="panel">
        <p> - We accept payments via credit/debit cards (Visa, Mastercard, American Express), PayPal, and other secure online payment methods.</p>
    </div> <!-- REMOVE div to include button in a button -->


    <button class="accordion">Do you offer international shipping?</button>
    <div class="panel">
        <p>- Yes, we offer international shipping to many countries. Please check our shipping information page for details on specific countries and shipping rates..</p>
    </div>

    <button class="accordion">How can I track my order?</button>
    <div class="panel">
        <p>- Once your order has been shipped, you will receive a tracking number via email. You can use this tracking number to monitor the status of your shipment on our website or the shipping carrier's website.</p>
    </div>
    <button class="accordion">What is your return policy?</button>
    <div class="panel">
        <p>- We offer a hassle-free return policy within 90 days of purchase. Please see our Returns & Exchanges page for more details on how to initiate a return.</p>
    </div>

    <button class="accordion">Do you offer warranty on your products?</button>
    <div class="panel">
        <p>- Yes, many of our products come with a manufacturer's warranty. The duration and terms of the warranty vary depending on the product. Please refer to the product description or contact us for more information.</p>
    </div>

    <button class="accordion">Can I cancel my order after it has been placed?</button>
    <div class="panel">
        <p>- Orders can typically be canceled within a short window of time after they are placed. Please contact our customer service team as soon as possible to inquire about canceling your order.</p>
    </div>

    <button class="accordion">How do I know what size to order?</button>
    <div class="panel">
        <p>- We provide detailed sizing charts for each product to help you choose the correct size. If you have any questions about sizing, feel free to contact us for assistance.</p>
    </div>

    <button class="accordion">Are your products authentic?</button>
    <div class="panel">
        <p>- Yes, we are an authorized retailer of all the brands we carry, and our products are guaranteed to be 100% authentic.</p>
    </div>

    <button class="accordion">Do you offer bulk discounts for team orders?</button>
    <div class="panel">
        <p>- Yes, we offer discounts for bulk orders. Please contact our team sales department for more information on bulk pricing and customization options.</p>
    </div>

    <button class="accordion">Are your products authentic?</button>
    <div class="panel">
        <p>Yes, we are an authorized retailer of all the brands we carry, and our products are guaranteed to be 100% authentic.</p>
    </div>

    <button class="accordion">What if the item I want is out of stock?</button>
    <div class="panel">
        <p>- If an item is out of stock, you can sign up to be notified when it becomes available again. Alternatively, you can contact us to inquire about restocking timelines.</p>
    </div>

    <button class="accordion">Do you offer gift cards?</button>
    <div class="panel">
        <p>- Yes, contact us we offer electronic gift cards that can be purchased and redeemed online. They make a perfect gift for any sports enthusiast.</p>
    </div>

    <button class="accordion">How can I contact customer service??</button>
    <div class="panel">
        <p> - You can reach our customer service team via email, phone, or live chat during our business hours. Visit our Contact Us page for more information.</p>
    </div>

    <button class="accordion">Do you have a physical store location?</button>
    <div class="panel">
        <p>- At this time, we are an online-only retailer and do not have physical store locations.</p>
    </div>

    <button class="accordion">Can I place an order over the phone?</button>
    <div class="panel">
        <p>- Yes, our customer service team can assist you with placing an order over the phone if needed.</p>
    </div>

    <button class="accordion">Do you offer price matching?</button>
    <div class="panel">
        <p>- We strive to offer competitive prices on all our products. However, if you find an identical item at a lower price elsewhere, please contact us, and we'll do our best to match it.</p>
    </div>

    <button class="accordion">Are your products suitable for beginners?</button>
    <div class="panel">
        <p>- Yes, we carry a wide range of products suitable for beginners, as well as advanced athletes. Our product descriptions and customer reviews can help you find the right equipment for your skill level.</p>
    </div>

    <button class="accordion">What if I receive a damaged or defective item?</button>
    <div class="panel">
        <p>- If you receive a damaged or defective item, please contact our customer service team immediately, and we will arrange for a replacement or refund.</p>
    </div>

    <button class="accordion">Do you offer assembly services for larger equipment?</button>
    <div class="panel">
        <p>- Some larger equipment may require assembly. Assembly services may be available for an additional fee. Please contact us for more information.</p>
    </div>

    <button class="accordion">How can I stay updated on promotions and new products?</button>
    <div class="panel">
        <p>- You can sign up for our newsletter to receive updates on promotions, new product releases, and exclusive offers.</p>
    </div>

    <button class="accordion">Can I place an order for pickup?</button>
    <div class="panel">
        <p>- At this time, we only offer shipping for online orders. We do not currently offer in-store pickup.</p>
    </div>

    <button class="accordion">What if I need to change my shipping address after placing an order?</button>
    <div class="panel">
        <p>- Please contact our customer service team as soon as possible if you need to change your shipping address. We'll do our best to accommodate your request if the order hasn't shipped yet.</p>
    </div>

    <button class="accordion">Are there any restrictions on shipping certain products?</button>
    <div class="panel">
        <p>- Some products may be subject to shipping restrictions due to size, weight, or shipping regulations. Please check the product description and our shipping policy for any restrictions that may apply.</p>
    </div>

    <button class="accordion">Do you offer financing options for large purchases?</button>
    <div class="panel">
        <p>- Yes, we offer financing options through select third-party providers. Please contact us for more information on financing options.</p>
    </div>

    <button class="accordion">Can I customize team uniforms or apparel with logos or names?</button>
    <div class="panel">
        <p>- Yes, we offer customization services for team uniforms and apparel. Please contact our team sales department for more information on customization options and pricing.</p>
    </div>

    <button class="accordion">Do you have a loyalty rewards program?</button>
    <div class="panel">
        <p>- Yes, we offer a loyalty rewards program where you can earn points on purchases and redeem them for discounts on future orders. Visit our Rewards page for more information and to sign up.</p>
    </div>

    <!--<button class="accordion">?</button>
    <div class="panel">
        <p>- - You can reach our customer service team via email, phone, or live chat during our business hours. Visit our Contact Us page for more information.</p>
    </div>-->

</div> <!--container div -->
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
    window.addEventListener("load", function () {
        loader.style.display = "none";
    });
    <!-- accordian -->
    var acc = document.getElementsByClassName("accordion");
    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function () {
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.maxHeight) {
                panel.style.maxHeight = null;
            } else {
                panel.style.maxHeight = panel.scrollHeight + "px";
            }
        });
    }

</script>

<!--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script> -->
<script src="${pageContext.request.contextPath}/resources/JavaScript/script.js"></script>
</body>

</html>