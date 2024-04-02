<%@ page import="website.wesports.Business.Customer" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Logout</title>
</head>
<body>
    <%
        session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    %>
    <script type="text/javascript">
        window.location.replace("${pageContext.request.contextPath}/Home.html");
    </script>




</body>
</html>