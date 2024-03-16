<%--
 Class: CIST 2931 : Advanced Systems Project Management
 Term: Spring 2024
 Instructor: Chris Bishop
 Description: Customer Business Object
 Authors: Diego Carrillo Garcia, Heather Papp
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
    <title>Signup & Login</title>
    <link rel="stylesheet" href="../css/Signup.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  </head>

  <body>

    <div class="wrapper">
      <form action="CustomerLoginServlet" name="CustomerLoginForm" method="post">
        <h2 style="text-align: center;">Welcome Back!</h2>
        <h1>Login</h1>
        <div class="input-box">
          <input type="text" placeholder="Username" name="Username" id="Username" required>
          <i class='bx bxs-user'></i>
        </div>
        <div class="input-box">
          <input type="password" placeholder="Password" name="Password" id="Password" required>
          <i class='bx bxs-lock-alt' ></i>
        </div>
        <div class="remember-forgot">
          <label><input type="checkbox">Remember Me</label>
          <a href="#">Forgot Password?</a>
        </div>
          <button type="submit" name="Submit" id="Submit" class="btn">Login</button>
        <div class="register-link">
          <p>Don't have an account?<a href="../WEB-INF/Register.jsp"> Register</a></p>
        </div>
        <div class="distributor">
          <p>Distributors Login<a href="../WEB-INF/DistributorsLogin.jsp"> Here</a></p>
        </div>
      </form>
    </div>
  </body>
</html>