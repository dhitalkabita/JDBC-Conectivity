package CommonConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteStudent {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            String deleteSQL = "DELETE FROM students WHERE name = ?";
            PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setString(1, "Kabita");
            pstmt.executeUpdate();
            System.out.println("✅ Student deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
