<!DOCTYPE html>
<%@ page import="website.wesports.Business.Customer" %>
<html>
    <head>

        <meta name="viewport" content="width=device-with, initial-scale=1.0">
        <title>WeSports | About</title>
        <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/favicon-16x16.png">
        <link rel="manifest" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/site.webmanifest">
        <link rel="mask-icon" href="${pageContext.request.contextPath}/resources/favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
        <meta name="msapplication-TileColor" content="#da532c">
        <meta name="theme-color" content="#ffffff">
        <!--<link rel="stylesheet" href="/Website/CSS/styles.css">Need to edit about styles to not conflict-->
        <!--<link rel="stylesheet" href="../resources/css/styles.css">-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/aboutStyles.css">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/5b6c8cdace.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/customerProfile.css">

    </head>
    <body>
        <div class="BGcontainer">
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

                <!-- Logged in Customer -->
                <%
                    Customer c1 = (Customer) session.getAttribute("c1");
                    c1.display();
                %>
                <!-- Customer menu button show account options in dropdown -->
                <div class="customerMenu">
                    <button>Account</button>
                    <div class="customerMenu-content">
                        <a href="${pageContext.request.contextPath}/customer/CustomerProfile.jsp">Account Home</a>
                        <a href="${pageContext.request.contextPath}/customer/CustomerUpdateProfile.jsp">Update Account</a>
                        <a href="${pageContext.request.contextPath}/customer/CustomerOrders.jsp">Orders</a>
                        <a href="${pageContext.request.contextPath}/shop/Help.jsp">Help & FAQs</a>
                        <a href="${pageContext.request.contextPath}/Home.html">Logout</a>
                    </div>
                </div>
                <a href="${pageContext.request.contextPath}/shop/Cart.jsp" class="btn">
                    <i class="fa-solid fa-cart-shopping"></i> Cart
                </a>

                <!-- other page elements not used here
                <a href="CustomerLogin.jsp" class="login-button">Login</a>
                <a href="../shop/Cart.html" class="btn">
                    <i class="fa-solid fa-cart-shopping"></i> Cart
                </a>
                -->

            </nav>

            <div class="alignment">
                                                                <!-- about us-->
                <div class="main">
                    <div class="flip-card">
                        <div class="flip-card-inner">
                            <div class="flip-card-front" >
                                <h1 class= "container"> About us </h1>
                                <p>
                                    <h3> How we started....</h3>
                                </p>

                            </div>
                            <div class="flip-card-back">
                                <br>
                                <h2>
                                    <br>
                                    <p>In January of 2024 a select number students were assigned a task.</p>
                                    <p>Create a website for the senior class project. </p>
                                    <p>This was no ordinary project. It was a project to create a</p>
                                    <p> sporting goods page.</p>
                                    <br>
                                    <p>The rest is history</p>
                                </h2>
                            </div></div></div></div>


                                                                 <!-- Events-->

                <div class="main">
                    <div class="flip-card">
                        <div class="flip-card-inner">
                            <div class="flip-card-front">
                                <h1 class= "container"> Events </h1>
                                <br>
                                <p>
                                <br>
                                <br>
                                <h3>Check out what's going on!</h3>
                                <br>
                                <br>
                                <br>
                                </p>
                            </div>
                            <div class="flip-card-back">
                                <p>
                                <h2>
                                    <br>
                                    <p>Upcoming Events</p>
                                    <br>Soccer Lessons - 15th
                                    <br>
                                    <p>Crabcakes and Football - 27th</p>
                                    <br>
                                    <p>Olympics Sale 50% off - 29th(Every Month)</p>
                                    <br>
                                    <br>
                                    </p>
                                </h2>
                            </div></div></div></div>


                                                                                <!-- Services-->

                <div class="main">
                    <div class="flip-card">
                        <div class="flip-card-inner">
                            <div class="flip-card-front">
                                <h1 class= "container"> Services </h1><span class="ribbon">NEW!</span>
                                <p>
                                <h2>
                                    <br>
                                    <br>Gear Cleaning</br>
                                    <br>
                                    <br>Community Connect
                                    <br>
                                    <br>Scout requests
                                    <br>
                                    <br>
                                    </p>
                                </h2>
                            </div>
                            <div class="flip-card-back">
                                <p>
                                <h2>
                                    <br>Click below to recieve info
                                    <br>
                                    <br>directly to email
                                    <br>
                                    <br>No signing up required
                                    <br>
                                    </p>
                                    <br>
                                    <br>
                                    <p>
                                        <button class="btn"><a href="../shop/thanks.html">Subscribe</a><span class="ribbon">click</span></button>
                                    </p>
                                    <br>
                                    <br>
                                </h2>
                            </div></div></div></div>

                                                                <!-- Journey -->

                <div class="main">
                    <div class="flip-card">
                        <div class="flip-card-inner">
                            <div class="flip-card-front">
                                <h1 class= "container"> Journey </h1><span class="ribbon">NEW!</span>
                                <br>
                                <br>
                                <br>
                                <h3>What's going on behind the scenes?</h3>
                                <br>
                                <h3>Get the stats.</h3>
                                <br>
                                <br>
                                </p>
                            </div>
                            <div class="flip-card-back">
                                <p>
                                <h1>Analytics</h1>
                                <h2>
                                    <br><a href="https://www.figma.com/file/FSbUEQ1jmHuOSOU9EWT3j2/SportingFlow?type=whiteboard&node-id=0%3A1&t=AwMhwfw5V1Z9fVEg-1">- Flow Charts</a>
                                    <br>
                                    <br><a href="${pageContext.request.contextPath}/resources/pictures/UX/Colors.jpg">- Color Scheme</a>
                                    <br>
                                    <br><a href="${pageContext.request.contextPath}/resources/pictures/UX/Persona 2.png">- Character Study</a>
                                    <br>
                                    <br><a href="${pageContext.request.contextPath}/resources/pictures/UX/Persona 1.png">- Character Study</a>
                                    <br>
                                    <br><a href="../resources/pictures/UX/User Journey Mapping.png">- User Mapping</a>
                                    <br>
                                    <br>
                                    <button class="btn"><a href="https://analysis-page.framer.ai/">Analytics Tool</a></button>
                                    <br>
                                    <br>
                                    </p>
                                </h2>
                            </div>
                        </div>
                    </div>
                </div>

                    <!--<p class="aboutp">1.Going to add cards that flip to reveal info about company
                        <br>2. adding a card about service like clubs to join
                        <br>3. adding card about events
                        <br>4. adding card about the companys journey, analytics/ everything that went on behind the scenes
                    </p>-->

            </div>  <!-- end alignment -->
    </div> <!--bgclass-->

      <!-- Footer With Links-->
        <footer class="footer">
            <p>WeSports</p>
            <nav>
                <ul>
                    <!--<li><a href="about.jsp">About us</a></li>-->
                    <li><a href="${pageContext.request.contextPath}/shop/Home.jsp">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/shop/contact.jsp">Contact Us</a></li>
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


        <script src="${pageContext.request.contextPath}//resources/JavaScript/script.js"></script>

    </body>
</html>