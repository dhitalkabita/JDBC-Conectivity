package CommonConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            String createSQL = """
                CREATE TABLE IF NOT EXISTS students (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    age INT,
                    email VARCHAR(100) UNIQUE
                );
            """;

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(createSQL);
            System.out.println("✅ Table 'students' created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

