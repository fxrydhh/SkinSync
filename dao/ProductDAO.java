package dao;

import java.sql.*;

import db.DBConnection;
import models.Product; // 1. Links to your Product model

public class ProductDAO {
    public boolean addProduct(Product product) {
        // Updated to use the Product object, matching your UserDAO style
        String sql = "INSERT INTO products (product_name, price, stock) VALUES (?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, product.getProductName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getStock());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}