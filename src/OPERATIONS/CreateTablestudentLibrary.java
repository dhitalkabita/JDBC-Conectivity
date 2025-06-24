package OPERATIONS;

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTablestudentLibrary {

        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/studentdb"; // Replace with your DB name
            String user = "root"; // DB username
            String password = "J@v@123"; // DB password

            // SQL to create the table

            String sql = "CREATE TABLE IF NOT EXISTS studentLibrary (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(50) NOT NULL, " +
                    "age INT, " +
                    "gender VARCHAR(10), " +
                    "address VARCHAR(100), " +
                    "phone VARCHAR(15) UNIQUE, " +
                    "email VARCHAR(100) UNIQUE, " +
                    "enrollment DATE" +
                    ")";


            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement()) {

                stmt.execute(sql);
                System.out.println("Table 'studentLibrary' created successfully.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



