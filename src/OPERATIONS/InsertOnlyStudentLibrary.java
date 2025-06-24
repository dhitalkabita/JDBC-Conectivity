package OPERATIONS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertOnlyStudentLibrary {

        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/studentdb"; // Your DB name
            String user = "root"; // DB username
            String password = "J@v@123"; // DB password

            // SQL to insert a record
            String insertSQL = "INSERT INTO studentLibrary (name, age, gender, address, phone, email, enrollment) VALUES " +
                    "('Kabita ', 29, 'Female', 'Kathmandu, Nepal', '9812345678', 'kabita@example.com', '2023-06-23')";

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement()) {

                int rowsInserted = stmt.executeUpdate(insertSQL);

                if (rowsInserted > 0) {
                    System.out.println("A new record inserted successfully!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


