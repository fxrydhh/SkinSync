package db;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    // Note the 8081 port we changed earlier
    private static String url = "jdbc:mysql://localhost:3306/skinsync_db"; 
    private static String user = "root";
    private static String password = ""; 

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Successful!");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e.getMessage());
        }
        return con;
    }
    // Add this to test the connection!
    public static void main(String[] args) {
        getConnection();
    }
}