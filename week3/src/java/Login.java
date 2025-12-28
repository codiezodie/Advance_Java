
/*?import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String userName = request.getParameter("UserName");
        String password = request.getParameter("Password");

        System.out.println("UserName: " + userName); // Debug statement
        System.out.println("Password: " + password); // Debug statement
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String url = "jdbc:mysql://localhost:3306/dataR";
            String user = "root";
            String pwd = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pwd);
            
            String query = "SELECT * FROM tableR WHERE userName = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            
            // Check if a user was found
            if (rs.next()) {
                String myPassword = rs.getString("Password");
                String myemail = rs.getString("UserEmail");
                
                // Debugging password comparison
                System.out.println("Stored Password: " + myPassword); // Debug statement
                if (password.equals(myPassword)) {
                    request.setAttribute("UserName", userName);
                    request.setAttribute("UserEmail", myemail);
                    
                    // Redirect to homepage
                    RequestDispatcher rd = request.getRequestDispatcher("/Homepage.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("errorMessage", "User ID or password is incorrect.");
                    RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
                    rd.include(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
            rd.include(request, response);
        } 
        }
    
}/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        String userName = request.getParameter("UserName");
        String password = request.getParameter("Password");
        
        PrintWriter pw = response.getWriter();
        
     
        String url = "jdbc:mysql://localhost:3306/dataR";
        String user = "root";
        String pwd = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            
            String query = "SELECT * FROM tableR WHERE userName = ?";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String userNameFromDb = rs.getString("UserName");
                String passwordFromDb = rs.getString("Password");
                String emailFromDb = rs.getString("email");
                
                if(password.equals(passwordFromDb)){
                    pw.write("<h3>User verified successfully</h3>");
                   
                    RequestDispatcher rd = request.getRequestDispatcher("./Homepage.jsp");
                    request.setAttribute("UserName", userNameFromDb);
                    request.setAttribute("UserEmail", emailFromDb);
                    
                    rd.include(request, response);
                    
                }else{
                    pw.write("<h3>Userid or password is incorrect</h3>");
                    
                    RequestDispatcher rd = request.getRequestDispatcher("./Register.jsp");
                    rd.include(request, response);
                }
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

}