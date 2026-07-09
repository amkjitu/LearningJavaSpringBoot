<%--
Difference between JSP and Servlet:
1. JSP (JavaServer Pages) is a technology that allows for the creation of dynamic web pages using HTML, XML, or other document types, while Servlets are Java classes that handle requests and responses in a web application.
2. JSP is more suitable for presentation logic, allowing developers to embed Java code directly into HTML, whereas Servlets are better suited for business logic and processing requests.
3. JSP files are compiled into Servlets by the server, which means that they are easier to write and maintain for web page content, while Servlets require more boilerplate code and are typically used for handling complex logic.
4. JSP supports the use of custom tags and expression language (EL) to simplify the development process, while Servlets do not have built-in support for these features.
5. JSP allows for a more natural separation of concerns between the presentation layer and the business logic, while Servlets often mix both layers in a single class.
6. JSP pages can be easily modified and updated without recompiling the entire application, while Servlets require recompilation and redeployment for changes to take effect.
7. JSP is generally easier for designers to work with, as it allows them to focus on the HTML and layout, while Servlets require a deeper understanding of Java programming.

--%>


<%--
A registration form is as follows:
--%>
<html>
  <head>
    <title>Registration Form</title>
  </head>
  <body>
    <h1>Registration Form</h1>
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