package CommonConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadStudents {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            String selectSQL = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectSQL);

            System.out.println("📄 Student Records:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " +
                        rs.getString("name") + " - " +
                        rs.getInt("age") + " - " +
                        rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
