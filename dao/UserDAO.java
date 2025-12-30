package dao;

import java.sql.*;
import models.User;
import db.DBConnection; // This is the missing link!

public class UserDAO {
    public boolean registerUser(User user) {
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
// Corrected block in UserDAO.java
ps.setString(1, user.getUsername()); // String for text
ps.setString(2, user.getEmail());    // CHANGED: String for text
ps.setString(3, user.getPassword()); // String for text
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}