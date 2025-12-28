import java.io.IOException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Updatebook"})
public class Updatebook extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Prepare book options dynamically for dropdown
        StringBuilder bookOptions = new StringBuilder();
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT bookId, bookName FROM books";
            try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    String bookId = rs.getString("bookId");
                    String bookName = rs.getString("bookName");
                    bookOptions.append("<option value='").append(bookId).append("'>").append(bookName).append("</option>");
                }
            }
            request.setAttribute("bookOptions", bookOptions.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error fetching books from database.");
        }

        // Forward to the JSP page
        RequestDispatcher rd = request.getRequestDispatcher("Updatebook.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the selected bookId and new details from the form
        String bookId = request.getParameter("bookSelect");
        String publisherName = request.getParameter("publisherName");
        String category = request.getParameter("category");

        // Update book details
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String queryUpdate = "UPDATE books SET publisherName = ?, category = ? WHERE bookId = ?";
            try (PreparedStatement ps = con.prepareStatement(queryUpdate)) {
                ps.setString(1, publisherName);
                ps.setString(2, category);
                ps.setString(3, bookId);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    request.setAttribute("successMessage", "Book updated successfully!");
                } else {
                    request.setAttribute("errorMessage", "Failed to update the book.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error occurred while updating the book.");
        }

        // Forward to the same page to show the result
        RequestDispatcher rd = request.getRequestDispatcher("Updatebook.jsp");
        rd.forward(request, response);
    }
}
