
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import dao.UserDAO;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Get data from the HTML form
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        // 2. Create a User object (OOP Principle)
        User newUser = new User(name, email, pass);

        // 3. Use DAO to save to Database
        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.registerUser(newUser);

        // 4. Redirect based on result
  if (isRegistered) {
    // This tells the browser to go to your new welcome page
    response.sendRedirect("welcome.html");
} else {
    // If it fails, send them back to try again
    response.sendRedirect("register.html?error=failed");
}
    }
}