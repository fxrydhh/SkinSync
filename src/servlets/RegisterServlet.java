package servlets; // Matches your new folder name

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// These connect this file to your other organized folders
import dao.UserDAO;
import models.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Get data from the HTML form (Check that these names match your register.html)
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        // 2. Create a User object
        User newUser = new User(name, email, pass);

        // 3. Use DAO to save to Database
        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.registerUser(newUser); // Renamed from 'isRegistered' to 'success'

        // 4. Redirect based on result
        if (success) {
            // Goes to your Proven-style welcome page
            response.sendRedirect("welcome.html");
        } else {
            // Sends them back to try again
            response.sendRedirect("register.html?error=failed");
        }
    }
}