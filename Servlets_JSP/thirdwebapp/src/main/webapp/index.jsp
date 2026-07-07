<html>
<%--http://localhost:8085/thirdwebapp_war_exploded/--%>
    <body>
    <h2>Registration Form</h2>
<%--        <form action="${pageContext.request.contextPath}/register" method="post">--%>
            <form action="./register" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br><br>
            <input type="submit" value="Register">
        </form>
    </body>
</html>
