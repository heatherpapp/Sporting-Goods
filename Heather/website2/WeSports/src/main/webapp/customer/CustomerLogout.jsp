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
            %>
    <a href="javascript:location.replace('${pageContext.request.contextPath}/shop/Home.html')"></a>
    <%
        }
    %>


</body>
</html>