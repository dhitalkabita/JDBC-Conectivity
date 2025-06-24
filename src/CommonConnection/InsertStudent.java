package CommonConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertStudent {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            String insertSQL = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, "Kabita");
            pstmt.setInt(2, 22);
            pstmt.setString(3, "kabita@example.com");
            pstmt.executeUpdate();
            System.out.println("✅ Student inserted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
