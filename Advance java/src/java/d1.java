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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/d1")
public class d1 extends HttpServlet {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASS = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        // List to hold book details
        List<String[]> bookList = new ArrayList<>();

        try {
            // Establish connection to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // SQL query to select all books
            String sql = "SELECT * FROM t1";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            // Retrieve book details and store them in the list
            while (rs.next()) {
                String bookId = rs.getString("bookId");
                String bookName = rs.getString("bookName");
                String authorName = rs.getString("authorName");
                String category = rs.getString("category");
                bookList.add(new String[]{bookId, bookName, authorName, category});
            }

            // Set the book list as an attribute to pass to the JSP
            request.setAttribute("bookList", bookList);

            // Forward the request to d1.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("d1.jsp");
            dispatcher.forward(request, response);
            
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        } finally {
            // Close the database resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

