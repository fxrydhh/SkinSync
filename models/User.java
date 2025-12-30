package models;

public class User {
    private String username;
    private String email;
    private String password;

    // The Constructor
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters - These MUST exist for UserDAO to work
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}