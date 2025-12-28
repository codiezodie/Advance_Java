import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Addbook")
public class Addbook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        // Form data
        String bookId = request.getParameter("bookId");
        String bookName = request.getParameter("bookName");
        String authorName = request.getParameter("authorName");
        String category = request.getParameter("category");

        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO books (bookId, bookName, authorName, category) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, bookId);
                ps.setString(2, bookName);
                ps.setString(3, authorName);
                ps.setString(4, category);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    pw.write("<h3>Book added successfully!</h3>");
                    RequestDispatcher rd = request.getRequestDispatcher("/Displaybook.jsp");
                    rd.include(request, response);
                } else {
                    pw.write("<h3>Failed to add book. Please check the data and try again.</h3>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            pw.write("<h3>Error occurred while adding the book. Details: " + e.getMessage() + "</h3>");
        }
    }
}
