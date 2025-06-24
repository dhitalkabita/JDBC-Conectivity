package CommonConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateStudent {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            String updateSQL = "UPDATE students SET age = ? WHERE name = ?";
            PreparedStatement pstmt = conn.prepareStatement(updateSQL);
            pstmt.setInt(1, 23);
            pstmt.setString(2, "Kabita");
            pstmt.executeUpdate();
            System.out.println("✅ Student updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
