/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Prabhakar Kumar
 */
//@WebServlet(urlPatterns = {"/Register"})
@WebServlet("/register") //URL mapping - Annotation
public class register extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        String userName = request.getParameter("UserName");
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");
        String confirmPassword = request.getParameter("ConfirmPassword");
       
        
        String url = "jdbc:mysql://localhost:3306/registration";
        String user = "root";
        String pwd = "";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            
            PreparedStatement ps = con.prepareStatement("insert into social_media values(?,?,?)");
        
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, email);
            
            int count = ps.executeUpdate();
            
            if(count > 0){
                out.print("<h3>User Registered Successfully</h3>");
                response.setContentType("text/html");
                RequestDispatcher rd = request.getRequestDispatcher("./register.jsp");
                rd.include(request, response);
            } else {
                out.print("<h3>Some Error Occurred</h3>");
                response.setContentType("text/html");
                RequestDispatcher rd = request.getRequestDispatcher("./register.jsp");
                rd.include(request, response);
            }
        }catch(Exception e){
            e.printStackTrace();
             response.setContentType("text/html");
                out.print("<h3 style='color:red'>Exception Occured:"+e.getMessage()+"</h3>");
                RequestDispatcher rd=request.getRequestDispatcher("/registration.jsp");
                rd.include(request,response);
           }
            
        
        
        
        if (password.equals(confirmPassword)){
            //We are going to put values in database
            
        }
                
    }

    
}
