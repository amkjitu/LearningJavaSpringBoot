<%--
  Created by IntelliJ IDEA.
  User: Roxnor
  Date: 7/9/2026
  Time: 12:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reg. Completed</title>
</head>
<body>
    <h1>Registration Completed Successfully!</h1>
    <p>Welcome, <%= session.getAttribute("username") %>!</p>
</body>
</html>
