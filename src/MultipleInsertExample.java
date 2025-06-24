import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MultipleInsertExample {


        public static void main(String[] args) {
            // Database credentials
            String url = "jdbc:mysql://localhost:3306/teacher"; // Your DB name
            String user = "root";  // Your DB username
            String password = "J@v@123";  // Your DB password

            // Sample data
            int[] ids = {5, 6, 7};
            String[] names = {"Rita", "Sita", "Hari"};
            String[] jobs = {"IT-job", "Admin", "Manager"};
            double[] salaries = {28000, 30000, 40000};

            // SQL Insert query with placeholders
            String query = "INSERT INTO employees(id, name, job_tittle, salary) VALUES (?, ?, ?, ?)";

            try {
                // Load JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish connection
                Connection conn = DriverManager.getConnection(url, user, password);
                System.out.println("DBConnection successful!");

                // Create PreparedStatement
                PreparedStatement pstmt = conn.prepareStatement(query);

                // Use a loop to insert multiple rows
                for (int i = 0; i < ids.length; i++) {
                    pstmt.setInt(1, ids[i]);
                    pstmt.setString(2, names[i]);
                    pstmt.setString(3, jobs[i]);
                    pstmt.setDouble(4, salaries[i]);

                    int rows = pstmt.executeUpdate();
                    System.out.println("Inserted row for ID: " + ids[i] + " | Rows affected: " + rows);
                }

                // Close resources
                pstmt.close();
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


