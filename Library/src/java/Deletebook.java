import java.io.IOException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Deletebook"})
public class Deletebook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pwd = "";
        
        // StringBuilder to hold book options
        StringBuilder bookOptions = new StringBuilder();
        
        try {
            // Load the JDBC driver and establish connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            
            // SQL query to get all books
            String query = "SELECT bookId, bookName FROM books";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            // Loop through the result set and generate options for the select dropdown
            while (rs.next()) {
                String bookId = rs.getString("bookId");
                String bookName = rs.getString("bookName");
                bookOptions.append("<option value='").append(bookId).append("'>").append(bookName).append("</option>");
            }
            
            // Set the book options as a request attribute
            request.setAttribute("bookOptions", bookOptions.toString());
            
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error fetching books from database.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database driver not found.");
        }

        // Forward the request to the JSP page
        RequestDispatcher rd = request.getRequestDispatcher("Deletebook.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get the selected book ID from the request
        String bookId = request.getParameter("bookSelect");
        
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pwd = "";
        
        try (Connection con = DriverManager.getConnection(url, user, pwd)) {
            String query = "DELETE FROM books WHERE bookId = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bookId);
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                response.getWriter().write("<h3>Book deleted successfully!</h3>");
            } else {
                response.getWriter().write("<h3>No book found with the given ID.</h3>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("<h3>Error occurred while deleting the book. Please try again.</h3>");
        }
    }
}
