package com.mycompany.app.util;

import java.sql.*;

public class JdbcUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("JDBC driver initialized.");
    }

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/learningrestapi"; // Replace with your database name
        String username = "root"; // Replace with your MySQL username
        String password = ""; // Replace with your MySQL password
        return DriverManager.getConnection(url, username, password);
    }

    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
