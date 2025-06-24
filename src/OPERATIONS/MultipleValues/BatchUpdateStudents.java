package OPERATIONS.MultipleValues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchUpdateStudents {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "J@v@123";

        String updateSQL = "UPDATE studentLibrary SET age = ?, address = ? WHERE phone = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            // First update
            pstmt.setInt(1, 30);
            pstmt.setString(2, "Lalitpur, Nepal");
            pstmt.setString(3, "9812345678");
            pstmt.addBatch();

            // Second update
            pstmt.setInt(1, 33);
            pstmt.setString(2, "Pokhara, Nepal");
            pstmt.setString(3, "9823456799");
            pstmt.addBatch();

            // Third update
            pstmt.setInt(1, 29);
            pstmt.setString(2, "Biratnagar, Nepal");
            pstmt.setString(3, "9834567870");
            pstmt.addBatch();

            // Execute batch update
            int[] results = pstmt.executeBatch();

            System.out.println(results.length + " records updated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
