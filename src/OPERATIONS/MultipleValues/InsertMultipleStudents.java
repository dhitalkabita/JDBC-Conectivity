package OPERATIONS.MultipleValues;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertMultipleStudents {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "J@v@123";

        String insertSQL = "INSERT INTO studentLibrary (name, age, gender, address, phone, email, enrollment) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            // First student
            pstmt.setString(1, "kabina Dhakal");
            pstmt.setInt(2, 29);
            pstmt.setString(3, "Female");
            pstmt.setString(4, "Kathmandu, Nepal");
            pstmt.setString(5, "9812345678");
            pstmt.setString(6, "kabina@example.com");
            pstmt.setDate(7, java.sql.Date.valueOf("2023-06-22"));
            pstmt.addBatch();

            // Second student
            pstmt.setString(1, "Ramila Shrestha");
            pstmt.setInt(2, 32);
            pstmt.setString(3, "Female");
            pstmt.setString(4, "Pokhara, Nepal");
            pstmt.setString(5, "9823456799");
            pstmt.setString(6, "ramilashrestha@example.com");
            pstmt.setDate(7, java.sql.Date.valueOf("2023-06-23"));
            pstmt.addBatch();

            // Third student
            pstmt.setString(1, "Sima Karki");
            pstmt.setInt(2, 28);
            pstmt.setString(3, "Female");
            pstmt.setString(4, "Biratnagar, Nepal");
            pstmt.setString(5, "9834567870");
            pstmt.setString(6, "simakarki@example.com");
            pstmt.setDate(7, java.sql.Date.valueOf("2023-06-24"));
            pstmt.addBatch();

            // Execute batch insert
            int[] results = pstmt.executeBatch();

            System.out.println(results.length + " records inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
