import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Addbook"})
public class Addbook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieving form data
        String bookId = request.getParameter("bookId");
        String bookName = request.getParameter("bookName");
        String authorName = request.getParameter("authorName");
        String category = request.getParameter("category");

        PrintWriter pw = response.getWriter();

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pwd = "";
        
        
        try {
            // Register the MySQL JDBC driver and establish a connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            
            // SQL query to insert the new book
            String query = "INSERT INTO books (bookId, bookName, authorName, category) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            // Set parameters to the prepared statement
            ps.setInt(1, Integer.parseInt(bookId));
            ps.setString(2, bookName);
            ps.setString(3, authorName);
            ps.setString(4, category);

            // Execute the query to insert data
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                pw.write("<h3>Book added successfully!</h3>");
            } else {
                pw.write("<h3>Failed to add book. Please try again.</h3>");
            }

            // Optionally, you can redirect to a page to display the updated book list
            RequestDispatcher rd = request.getRequestDispatcher("./Displaybook.jsp");
            rd.include(request, response);

        } catch (SQLException e) {
            pw.write("<h3>Error occurred while adding the book. Please check the server logs.</h3>");
            e.printStackTrace();  // Log the error details
        } catch (ClassNotFoundException e) {
            pw.write("<h3>Database driver not found. Please check the configuration.</h3>");
            e.printStackTrace();  // Log the error details
        } catch (Exception e) {
            pw.write("<h3>Unexpected error occurred. Please try again.</h3>");
            e.printStackTrace();  // Log the error details
        }
    }
}
