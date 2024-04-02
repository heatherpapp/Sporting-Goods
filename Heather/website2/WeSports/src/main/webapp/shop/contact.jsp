<!DOCTYPE html>
<%@ page import="website.wesports.Business.Customer" %>
<html>
    <head>
        <meta name="viewport" content="width=device-with, initial-scale=1.0">
        <title>WeSports | Contact</title>
        <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/favicon-16x16.png">
        <link rel="manifest" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/site.webmanifest">
        <link rel="mask-icon" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
        <meta name="msapplication-TileColor" content="#da532c">
        <meta name="theme-color" content="#ffffff">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>WeSports | Home</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/contact.css">
        <script src="https://kit.fontawesome.com/5b6c8cdace.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/customerProfile.css">
    </head>
    <body>
        <div class="BGcontainer">
            <nav>
            <a href="${pageContext.request.contextPath}/shop/Home.jsp">
                <img src="${pageContext.request.contextPath}//resources/pictures/clearw.png" class="logo">
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
                } else {
                %>
                <a href="${pageContext.request.contextPath}/customer/CustomerLogin.jsp" class="login-button">Login</a>
                <a href="${pageContext.request.contextPath}/shop/Cart.html" class="btn">
                    <i class="fa-solid fa-cart-shopping"></i> Cart
                </a>
                <%
                        }
                    }
                    catch (Exception e) {
                        System.out.println(e + "\nThere was an error with user buttons");
                    }

                %>
                <!-- END login/customer buttons -->
        </nav>
        <div class="row">
            <div class="column">
              <img src="${pageContext.request.contextPath}/resources/pictures/giphy (1).gif" style="width:100%" class ="giffy">
            </div>
            <div class="column">
              <form action="${pageContext.request.contextPath}/shop/thanks.jsp">
                <label for="fname">First Name</label>
                <input type="text" id="fname" name="firstname" placeholder="Your name..">
                <label for="lname">Last Name</label>
                <input type="text" id="lname" name="lastname" placeholder="Your last name..">
                <label for="country">Country</label>
                <select id="country" name="country">
                  <option value="australia">Australia</option>
                  <option value="canada">Canada</option>
                  <option value="usa">USA</option>
                </select>
                <label for="subject">Subject</label>
                <textarea id="subject" name="subject" placeholder="Write something.." style="height:170px"></textarea>
                <input type="submit" value="Submit">
              </form>
            </div>
          </div>
        </div>
                <!--<p class="contactp">1.simple copy and paste email address
                    <br>2. Click on link to access mail window
                    <br>3. paste address in mail service window

                </p>-->






        <!-- Footer With Links-->
            <footer class="footer">
                <p>WeSports</p>
                <nav>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/shop/about.jsp">About Us</a></li>
                        <li><a href="${pageContext.request.contextPath}/shop/Home.jsp">Home</a></li>
                        <!--<li><a href="thanks.jsp">Thank you</a></li>Not needed... Intended for contact page. So once they tried to contact us, it linked to a thank you page to acknowledge-->
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