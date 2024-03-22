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
    <link rel="stylesheet" href="/Website/CSS/Distributors.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  </head>

  <body>

    <div class="wrapper">
      <form action="DistributorLoginServlet" name="DistributorLoginForm" method="post">
        <h1>Login</h1>
        <div class="input-box">
          <input name="distUserNameInput" id="distUserNameInput" type="text" placeholder="Username" required>
           <i class='bx bxs-user'></i>
        </div>
        <div class="input-box">
          <input name=distPasswordInput" id="distPasswordInput" type="password" placeholder="Password" required>
           <i class='bx bxs-lock-alt' ></i>
        </div>

        <div class="remember-forgot">
          <label><input type="checkbox">Remember Me</label>
          <a href="#">Forgot Password?</a>
        </div>

        <button type="submit" class="btn">Login</button>

      </form>

    </div>

  </body>

</html>
