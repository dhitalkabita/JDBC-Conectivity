package OPERATIONS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableInsertvalue {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb"; // Your DB name
        String user = "root"; // DB username
        String password = "J@v@123"; // DB password

        // SQL to create the table (if not exists)
        String createTableSQL = "CREATE TABLE IF NOT EXISTS studentonly (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50) NOT NULL, " +
                "age INT, " +
                "gender VARCHAR(10), " +
                "enrollment DATE" +
                ")";

        // SQL to insert a record
        String insertSQL = "INSERT INTO studentonly (name, age, gender, address, phone, email, enrollment) VALUES " +
                "('Kabita Dhital', 28, 'Female', 'Kathmandu, Nepal', '9808918090', 'kabita12@example.com', '2023-06-20')";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Create table if it doesn't exist
            stmt.execute(createTableSQL);
            System.out.println("Table 'studentonly' created or already exists.");

            // Insert data into table
            int rowsInserted = stmt.executeUpdate(insertSQL);
            if (rowsInserted > 0) {
                System.out.println("A new student profile was inserted successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
