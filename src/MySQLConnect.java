import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class MySQLConnect {
    public static void main(String[] args) {
        // Database URL, username and password
        /// jdbc:mysql://localhost:3306/?user=root
        String url = "jdbc:mysql://localhost:3306/Students"; // Replace with your DB name
        String user = "root";  // Replace with your DB username
        String password = "J@v@123";  // Replace with your DB password

        try {
            // Load and register JDBC driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("DBConnection successful!");
            // Always close the connection when done
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("DBConnection failed!");
            e.printStackTrace();
        }
    }
}
