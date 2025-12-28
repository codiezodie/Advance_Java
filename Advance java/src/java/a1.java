/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/a1")
public class a1 extends HttpServlet {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASS = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the book details from the form
        String bookId = request.getParameter("bookId");
        String bookName = request.getParameter("bookName");
        String authorName = request.getParameter("authorName");
        String category = request.getParameter("category");

        // Database connection variables
        Connection conn = null;
        PreparedStatement stmt = null;
        

        try {
            // Establishing connection to the database
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // SQL query to insert book details
            String sql = "INSERT INTO t1 (bookId, bookName, authorName, category) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, bookId);
            stmt.setString(2, bookName);
            stmt.setString(3, authorName);
            stmt.setString(4, category);

            // Execute the query
            stmt.executeUpdate();
            
            // Redirect to the Displaybook page after saving
            response.sendRedirect("d1.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        } finally {
            // Close the resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
