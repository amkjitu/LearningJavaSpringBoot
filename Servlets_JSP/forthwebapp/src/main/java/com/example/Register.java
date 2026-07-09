/*
                      MVC Architecture

                   +------------------------+
                   |         MODEL          |
                   |         (JDBC)         |
                   +------------------------+
                      ^                  |
                      |                  |
                      |                  v
+---------+     +------------------------+     +------------------------+
| CLIENT  | --> |      CONTROLLER        | --> |         VIEW           |
+---------+     |       (Servlet)        | <-- |      JSP / HTML        |
      ^         +------------------------+     +------------------------+
      |                   |    ^
      |                   |    |
      +-------------------+----+
                          |
                          v
                   +------------------------+
                   |         MODEL          |
                   |         (JDBC)         |
                   +------------------------+

Flow:
------
1. Client  ------> Controller
2. Controller --> Model
3. Model -------> Controller
4. Controller --> View
5. View --------> Client
*/

package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class Register extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Model userModel = new Model();
        userModel.setUsername(username);
        userModel.setEmail(email);
        userModel.setPassword(password);

        int rowsUpdated = userModel.register();

        HttpSession session = req.getSession();
        session.setAttribute("username", username);

        if (rowsUpdated > 0) {
            res.sendRedirect("success.jsp");
        }
        else {
            res.sendRedirect("failure.jsp");
        }
    }
}
