/*
Java JDBC MySQL Example - jdbcUtil.java
Improved version of the JDBC utility class that provides methods to establish a connection to a MySQL database and close the connection and statement resources. It includes a static block to load the MySQL JDBC driver class when the class is loaded into memory.
This utility class provides methods to establish a connection to a MySQL database using JDBC and to close the connection and statement resources. It includes a static block to load the MySQL JDBC driver class when the class is loaded into memory.
This utility class can be used in other classes to simplify the process of connecting to a MySQL database and executing SQL queries.
This class is used in the LunchApp2.java class to establish a connection to the MySQL database and execute SQL queries.
*/
package one.utility;
import java.sql.*;

public class jdbcUtil {

    // static block to load the driver class when the class is loaded into memory
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // method to get a connection to the database
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/learningjdbc";
        String username = "root";
        String password = "";
        return DriverManager.getConnection(url, username, password);
    }

    // method to close the connection and statement
    public static void closeConnection(Connection conn, Statement stmt) {
        if (conn != null) {
            try {
                conn.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
