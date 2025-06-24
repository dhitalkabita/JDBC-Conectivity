import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDB {

    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/teacher"; // Replace with your DB name
        String user = "root";  // Replace with your DB username
        String password = "J@v@123";  // Replace with your DB password

        // SQL Insert query
        String query = "INSERT INTO employees(id, name, job_tittle, salary) VALUES (10, 'Meenna', 'IT-job', 28000)";

        try {
            // Load JDBC driver (optional in modern Java if you use JDBC 4.0+)
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
                System.out.println("Insert Successful. Rows affected: " + rowsAffected);
            } else {
                System.out.println("Insert Failed.");
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
