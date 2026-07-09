package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Model {

    // instance variables
    private String username;
    private String email;
    private String password;

    private Connection connection;
    private PreparedStatement pstmt;

    // Getters and Setters
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    // register the user
    public int register(){
        try{
            connection = JdbcUtil.getConnection();
            String insertUserSQLQuery = "INSERT INTO personalinfo (username, email, password) VALUES (?,?,?)";
            pstmt = connection.prepareStatement(insertUserSQLQuery);
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            JdbcUtil.closeConnection(connection, pstmt, null);
        }
    }

}
