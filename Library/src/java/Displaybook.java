import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.List;

public class Displaybook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        
        // Database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "") // replace with actual password
            ) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM books");
                
                // Collect books from database
                while (rs.next()) {
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set the books as a request attribute and forward to JSP
        //request.setAttribute("books", );
        RequestDispatcher rd = request.getRequestDispatcher("Displaybook.jsp");
        rd.forward(request, response);
    }
}
