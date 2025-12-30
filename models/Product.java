package models;

public class Product {
    private String product_name;
    private double price;
    private int stock;

    public Product(String product_name, double price, int stock) {
        this.product_name = product_name;
        this.price = price;
        this.stock = stock;
    }

    // These MUST match the calls in your ProductDAO
    public String getProductName() { return product_name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
}