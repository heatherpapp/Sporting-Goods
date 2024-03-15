<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-with, initial-scale=1.0">
        <title>We Sports | Home</title>
        <link rel="apple-touch-icon" sizes="180x180" href="/Website/favicon_package_v0.16/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="/Website/favicon_package_v0.16/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="/Website/favicon_package_v0.16/favicon-16x16.png">
        <link rel="manifest" href="/Website/favicon_package_v0.16/site.webmanifest">
        <link rel="mask-icon" href="/Website/favicon_package_v0.16/safari-pinned-tab.svg" color="#5bbad5">
        <meta name="msapplication-TileColor" content="#da532c">
        <meta name="theme-color" content="#ffffff">
        <link rel="stylesheet" href="/Website/CSS/styles.css">
        <script src="https://kit.fontawesome.com/5b6c8cdace.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <nav>
                <img src="/Website/Pictures/clearw.png" class="logo">
                <ul>
                
                    <div class="dropdown">
                        <button>Shop by Apparel</button>
                            <div class="dropdown-content">
                            <a href="Apparel/Mens.html">Men's</a>
                            <a href="Apparel/">Women's</a>
                            <a href="Apparel/">Junior's</a>
                            <a href="Apparel/">Youth</a>
                            </div>
                    </div>
                    <div class="dropdown">        
                        <button>Shop by Sport</button>
                            <div class="dropdown-content">
                            
                            <a href="Sports/Baseball.html">Baseball</a>
                            <a href="Sports/">Basketball</a>
                            <a href="Sports/">Football</a>
                            <a href="Sports/">Golf</a>
                            <a href="Sports/">Running</a>
                            <a href="Sports/">Soccer</a>
                            <a href="Sports/">Tennis</a>
                            <a href="Sports/">Volleyball</a>
                            
                            </div>
                            
                    </div>

                </ul>
                <a href="Login.html" class="login-button">Login</a>
        
                <a href="/Website/Cart.html" class="btn">
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
                <button id="search-button" onclick="search()">Search</button>
            </div>
            

            <div id="search-results">
                <!-- Search results will be displayed here -->
            </div>
            <div class="card">
                <a href="Baseball.jsp">
                    <img src="/Website/Pictures/man.jpg" alt="Image 1">
                    <button>Baseball</button>
                </a>
            </div>
            <div class="card">
                <a href="Basketball.jsp">
                    <img src="/Website/Pictures/woman.jpg" alt="Image 1">
                    <button>Basketball</button>
                </a>
            </div>
            <div class="card">
                <a href="Football.jsp">
                    <img src="/Website/Pictures/Kids.jpeg" alt="Image 1">
                    <button>Football</button>
                </a>
            </div>
            <div class="card">
                <a href="Golf.jsp">
                    <img src="/Website/Pictures/outdoor.jpeg" alt="Image 1">
                    <button>Golf</button>
                </a>
            </div>
            <div class="card">
                <a href="Running.jsp">
                    <img src="/Website/Pictures/outdoor.jpeg" alt="Image 1">
                    <button>Running</button>
                </a>
            </div>
            <div class="card">
                <a href="Soccer.jsp">
                    <img src="/Website/Pictures/outdoor.jpeg" alt="Image 1">
                    <button>Soccer</button>
                </a>
            </div>
            <div class="card">
                <a href="Tennis.jsp">
                    <img src="/Website/Pictures/outdoor.jpeg" alt="Image 1">
                    <button>Tennis</button>
                </a>
            </div>
            <div class="card">
                <a href="Volleyball.jsp">
                    <img src="/Website/Pictures/outdoor.jpeg" alt="Image 1">
                    <button>Volleyball</button>
                </a>
            </div>
        </div>

        <footer class="footer">
            <p>We Sports</p>
            <nav>
                <ul>
                    <li><a href="about.html">About us</a></li>
                    <li><a href="contact.html">Contact us</a></li>
                    <li><a href="thanks.html">Thank you</a></li>
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
    </body>
</html>