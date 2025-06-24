package OPERATIONS;

import java.sql.*;

public class SingleConnectionCRUD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "J@v@123";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected!");

            // CREATE
            String insertSQL = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setString(1, "Kabita");
                pstmt.setInt(2, 21);
                pstmt.setString(3, "kabita@example.com");
                pstmt.executeUpdate();
                System.out.println("Inserted");
            }

            // READ
            String selectSQL = "SELECT * FROM students";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSQL)) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + ": " + rs.getString("name"));
                }
            }

            // UPDATE
            String updateSQL = "UPDATE students SET age = ? WHERE name = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                pstmt.setInt(1, 22);
                pstmt.setString(2, "Kabita");
                pstmt.executeUpdate();
                System.out.println("Updated");
            }

            // DELETE
            String deleteSQL = "DELETE FROM students WHERE name = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
                pstmt.setString(1, "Kabita");
                pstmt.executeUpdate();
                System.out.println("Deleted");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
