import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDataExample {

    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/teacher"; // Replace with your DB name
        String user = "root";  // Replace with your DB username
        String password = "J@v@123";  // Replace with your DB password

        // SQL Update query
        String query = "UPDATE employees SET salary = 30000 WHERE id = 8";

        try {
            // Load JDBC driver (optional in modern Java)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("DBConnection successful!");

            // Create statement
            Statement stmt = conn.createStatement();

            // Execute update
            int rowsAffected = stmt.executeUpdate(query);

            // Check result
            if (rowsAffected > 0) {
                System.out.println("Update Successful. Rows affected: " + rowsAffected);
            } else {
                System.out.println("Update Failed or no rows matched.");
            }

            // Close resources
            stmt.close();
            conn.close();
            System.out.println("DBConnection closed successfully.");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception occurred.");
            e.printStackTrace();
        }
    }
}
