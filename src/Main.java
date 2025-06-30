import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Database URL, username and password
        String url = "jdbc:mysql://localhost:3306/teacher"; // Replace with your DB name
        String user = "root";  // Replace with your DB username
        String password = "J@v@123";  // Replace with your DB password
        String query = "SELECT * FROM employees";
        try {
            // Load and register JDBC driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("DBConnection successful!");
//sql query run
            //Statement is used to send SQL queries to the database.
 Statement stmt=conn.createStatement();   // take no agr-– it's a basic SQL execution tool.
            ResultSet rs = stmt.executeQuery(query);
while(rs.next()){
    int id= rs.getInt("id");
    String name=rs.getString("name");
    String Job=rs.getString("job_tittle");
    double salary=rs.getDouble("salary");
    System.out.println("");
    System.out.println("==========================");
    System.out.println("id: " +id);
    System.out.println("Name: " +name);
    System.out.println("Job: "+Job);
    System.out.println("Salary: "+salary);

}
            // Always close the connection when done
            conn.close();
rs.close();
stmt.close();
            System.out.println();
            System.out.println("DBConnection Closed Sucessfully!!! ");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("DBConnection failed!");
            e.printStackTrace();
        }
    }
}
