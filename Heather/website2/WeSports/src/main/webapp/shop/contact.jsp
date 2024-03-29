<!DOCTYPE html>
<%@ page import="website.wesports.Business.Customer" %>
<html>
    <head>
        <meta name="viewport" content="width=device-with, initial-scale=1.0">
        <title>WeSports | Contact</title>
        <link rel="apple-touch-icon" sizes="180x180" href="../resources/favicon_package_v0.16/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="../resources/favicon_package_v0.16/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="../resources/favicon_package_v0.16/favicon-16x16.png">
        <link rel="manifest" href="../resources/favicon_package_v0.16/site.webmanifest">
        <link rel="mask-icon" href="../resources/favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
        <meta name="msapplication-TileColor" content="#da532c">
        <meta name="theme-color" content="#ffffff">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>WeSports | Home</title>
        <link rel="stylesheet" href="../resources/css/styles.css">
        <link rel="stylesheet" href="../resources/css/contact.css">
        <script src="https://kit.fontawesome.com/5b6c8cdace.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="BGcontainer">
            <nav>
            <a href="../Home.html">
                <img src="../resources/pictures/clearw.png" class="logo">
            </a>
            <ul>

                <div class="dropdown">
                    <button>Shop by Sport</button>
                    <div class="dropdown-content">

                        <!--Need to Update links to JSP on all-->
                        <a href="sports/Baseball.jsp">Baseball</a>
                        <a href="sports/Basketball.jsp">Basketball</a>
                        <a href="sports/Cycling.jsp">Cycling</a>
                        <a href="sports/Football.jsp">Football</a>
                        <a href="sports/Golf.jsp">Golf</a>
                        <a href="sports/Running.jsp">Running</a>
                        <a href="sports/Soccer.jsp">Soccer</a>
                        <a href="sports/Tennis.jsp">Tennis</a>
                        <a href="sports/Volleyball.jsp">Volleyball</a>
                    </div>
                </div>

                <div class="dropdown">
                    <button>Shop Outdoors</button>
                    <div class="dropdown-content">
                        <a href="outdoors/Camping.jsp">Camping</a>
                        <a href="outdoors/Climbing.jsp">Climbing</a>
                        <a href="outdoors/Fishing.jsp">Fishing</a>
                        <a href="outdoors/Kayaking.jsp">Kayaking</a>
                    </div>
                </div>

                <div class="dropdown">
                    <button>Shop by Apparel</button>
                    <div class="dropdown-content">
                        <a href="apparel/Men.jsp">Men's</a>
                        <a href="apparel/Women.jsp">Women's</a>
                        <a href="apparel/Junior.jsp">Junior's</a>
                        <a href="apparel/Youth.jsp">Youth</a>
                    </div>
                </div>

            </ul>
            <a href="../customer/CustomerLogin.jsp" class="login-button">Login</a>

            <a href="../shop/Cart.html" class="btn">
                <i class="fa-solid fa-cart-shopping"></i> Cart
              </a>
        </nav>
        <div class="row">
            <div class="column">
              <img src="../resources/pictures/giphy (1).gif" style="width:100%" class ="giffy">
            </div>
            <div class="column">
              <form action="thanks.html">
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
                        <li><a href="../shop/about.html">About Us</a></li>
                        <li><a href="../Home.html">Home</a></li>
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


            <script src="../resources/JavaScript/script.js"></script>

    </body>
</html>