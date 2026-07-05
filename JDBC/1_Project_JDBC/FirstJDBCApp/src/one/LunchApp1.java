/*
Java JDBC MySQL Example - LunchApp1.java
This example demonstrates how to connect to a MySQL database using JDBC, execute SQL queries, and process the results. It includes operations such as SELECT, INSERT, UPDATE, and DELETE on a sample table named "studentinfo".

*/
package one;
import java.sql.*;
public class LunchApp1 {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, JDBC MYSQL!");

        try {
            //Step 1: Load the driver and register it with DriverManager
            Class.forName("com.mysql.cj.jdbc.Driver"); //equivalent: Class.forName("com.mysql.jdbc.Driver"); + DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //Step 2: Create a connection
            String url = "jdbc:mysql://localhost:3306/learningjdbc";
            Connection conn = DriverManager.getConnection(url, "root", "");
            if (conn != null)
                System.out.println("Connection established!");

            //Step 3: Create a statement
            Statement stmt = conn.createStatement();

            //Step 4: Execute a query
            String selectStu = "SELECT * FROM studentinfo";

            //Step 5: Process the result set
            ResultSet rs = stmt.executeQuery(selectStu); //this is select operation

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("sname");
                String email = rs.getString("sage");
                String city = rs.getString("scity");
                System.out.println(id + " " + name + " " + email + " " + city);
            }

            // as we have no data in the table above rs will be empty and the while loop will not execute.

            // let's insert some data into the table and then run the query again
            String insertStu1 = "INSERT INTO studentinfo (sname, sage, scity) VALUES ('John Doe', '20', 'New York')";
            int rowsAffected = stmt.executeUpdate(insertStu1); //this is a non-select operation (insert, update, delete)

            String insertStu2 = "INSERT INTO studentinfo (sname, sage, scity) VALUES ('Jane Smith', '22', 'Los Angeles')";
            rowsAffected = stmt.executeUpdate(insertStu2); //this is a non-select operation (insert, update, delete)

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
            }
            else {
                System.out.println("Data insertion failed!");
            }

            // let's update the data in the table and then run the query again
            String updateStu = "UPDATE studentinfo SET scity = 'Los Angeles' WHERE sname = 'John Doe'";
            rowsAffected = stmt.executeUpdate(updateStu); //this is a non-select operation (insert, update, delete)
            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
            }
            else {
                System.out.println("Data update failed!");
            }

            //let's delete the data in the table and then run the query again
            String deleteStu = "DELETE FROM studentinfo WHERE sage = '18'";
            rowsAffected = stmt.executeUpdate(deleteStu); //this is a non-select operation (insert, update, delete)
            if (rowsAffected > 0) {
                System.out.println("Data deleted successfully!");
            }
            else {
                System.out.println("Data deletion failed!");
            }
            
            //close the connection
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Unknown error occurred!");
        }
        
    }
}
