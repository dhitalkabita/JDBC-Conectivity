package OPERATIONS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabaseExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/"; // Note: no database specified here
        String user = "root";
        String password = "J@v@123";
        String query = "CREATE DATABASE IF NOT EXISTS studentdb";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) { //It creates a Statement object for sending SQL statements to the database.

            stmt.executeUpdate(query);
            System.out.println("Database 'studentdb' created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
