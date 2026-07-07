/*
As we know that HttpServlet is Controller so it is not recommended to do database connections, business logics(queries), and views(ui that users see).
To overcome these the MVC architecture comes into picuture. In MVC architecture, we have three layers:
1. Model: This layer is responsible for database connections and business logics(queries).
2. View: This layer is responsible for the user interface that users see.
3. Controller: This layer is responsible for handling user requests and responses.
which we will see this into the forthwebapp
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


@WebServlet("/register")
public class MyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        response.setContentType("text/plain;charset=UTF-8");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/learningservletjsp";
            String dbUsername = "root";
            String dbPassword = "";
            String sql = "INSERT INTO personalinfo (username, email, password) VALUES (?, ?, ?)";

            try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    response.getWriter().write("Registration successful!");
                } else {
                    response.getWriter().write("Registration failed!");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException("Unable to register user", e);
        }


    }
}