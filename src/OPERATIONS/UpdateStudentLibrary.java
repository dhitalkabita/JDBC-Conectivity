package OPERATIONS;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateStudentLibrary {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "J@v@123";

        // Example: Update age and address where phone = '9812345678'
        String updateSQL = "UPDATE studentLibrary SET age = 28, address = 'Lalitpur, Nepal' WHERE phone = '9812345678'";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            int rowsUpdated = stmt.executeUpdate(updateSQL);

            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully!");
            } else {
                System.out.println("No matching record found to update.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
