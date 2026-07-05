/*
Java JDBC MySQL Example - LunchApp2.java
1. This example demonstrates how to connect to a MySQL database using the jdbcUtil class.
2. Difference between createStatement() and prepareStatement() in JDBC:
   - createStatement(): This method is used to create a Statement object for executing simple SQL queries without parameters. It is suitable for executing static SQL statements that do not require input parameters.
  
   - prepareStatement(): This method is used to create a PreparedStatement object for executing parameterized SQL queries. It allows you to define placeholders (using ?) in the SQL statement, which can be filled with actual values at runtime. Prepared statements are more efficient and secure, as they help prevent SQL injection attacks and can be reused with different parameter values.

3. Batch processing in JDBC:
   - Batch processing allows you to group multiple SQL statements together and execute them as a single batch. This can improve performance by reducing the number of round trips to the database. The batch processing feature is only working for non-select operations (insert, update, delete) and not for select operations.
   - You can add multiple SQL statements to a batch using the addBatch() method of the Statement or PreparedStatement object, and then execute the batch using the executeBatch() method.

    How to interpret executeBatch() return values:
    The int[] array returned by executeBatch() will always match the number of statements you added using .addBatch(). 
    For standard manipulation queries (INSERT, UPDATE, DELETE), each number in the array indicates the row count affected by that specific batch step:
        - Greater than or equal to 0: The command executed successfully, and the number represents the count of rows affected.
        - SUCCESS_NO_INFO (or -2): The command executed successfully, but the database driver cannot determine how many rows were affected.
        - EXECUTE_FAILED (or -3): The specific command failed (this only happens if your driver continues processing the rest of the batch after an error).
    For example:
    int[] batchResults = pstmtBatch.executeBatch();
    System.out.println("Batch results: " + java.util.Arrays.toString(batchResults));
    Output: Batch results: [1, 1] indicates that both batch commands executed successfully, each batch affecting one row.
            Batch results: [1, 3] indicates that the first batch command affected one row, while the second batch command affected three rows.

*/
package one;

import one.utility.*;
import java.sql.*;
import java.util.Scanner;

public class LunchApp2 {
    public static void main(String[] args) {
        System.out.println("Hello, JDBC MYSQL!");

        try {
            //Step 1: Create a connection
            Connection conn = jdbcUtil.getConnection();
            if (conn != null)
                System.out.println("Connection established!");

            //Step 2: Create a statement & execute a query
            /// 1. createStatement() is used to create a Statement object for executing simple SQL queries without parameters. It is suitable for executing static SQL statements that do not require input parameters.
            Statement stmt = conn.createStatement();
            String selectStu = "INSERT INTO studentinfo (sname, sage, scity) VALUES ('Alice Johnson', '21', 'Chicago')";
            int rowsAffected = stmt.executeUpdate(selectStu); //this is insert operation
            System.out.println("Rows affected: " + rowsAffected);

            /// 2. prepareStatement() is used to create a PreparedStatement object for executing parameterized SQL queries. It allows you to define placeholders (using ?) in the SQL statement, which can be filled with actual values at runtime. Prepared statements are more efficient and secure, as they help prevent SQL injection attacks and can be reused with different parameter values.
            String insertStu = "INSERT INTO studentinfo (sname, sage, scity) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertStu);

            System.out.println("Enter the following details to insert in studentinfo: ");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter student age: ");
            Integer age = Integer.parseInt(sc.nextLine());
            System.out.print("Enter student city: ");
            String city = sc.nextLine();
            sc.close();

            // Set the parameter values for the PreparedStatement
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, city);

            // Execute the prepared statement
            int rowsAffected2 = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected2);

            // 3. Batch processing in JDBC:
            String deleteStu = "DELETE FROM studentinfo WHERE sname = ?";
            PreparedStatement pstmtBatch = conn.prepareStatement(deleteStu);
            pstmtBatch.setString(1, "tui");
            pstmtBatch.addBatch();
            pstmtBatch.setString(1, "gui");
            pstmtBatch.addBatch();
            int[] batchResults = pstmtBatch.executeBatch();
            System.out.println("Batch results: " + java.util.Arrays.toString(batchResults));


            //close the connection
            jdbcUtil.closeConnection(conn, stmt);
            jdbcUtil.closeConnection(conn, pstmt);

            //The same way we can update, delete, and select data from the database using prepared statements.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
