/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

/*import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class Calculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, 
                         HttpServletResponse response) throws IOException, ServletException {
        
        //PrintWriter is a class which prints response from server to client
        PrintWriter pw = response.getWriter();
        
        int n1 = Integer.parseInt(request.getParameter("n1"));
        int n2 = Integer.parseInt(request.getParameter("n2"));
        int sum, sub, mul;
        float div;
        
        String operation = request.getParameter("cal");
        RequestDispatcher rd= request.getRequestDispatcher("/.Calculator.html");
        response.setContentType("text/html");
        rd.include(request,response);
        
        if(operation.equals("+")){
             sum = n1+n2;
             pw.write("Sum = "+sum);
        }else if(operation.equals("-")){
            sub = n1-n2;
             pw.write("Difference = "+sub);
        } else if(operation.equals("*")){
            mul = n1*n2;
             pw.write("Product = "+mul);
        }else if(operation.equals("/")){
            div = (float)n1/n2;
             pw.write("Division = "+div);
        }      
        //pw.write("Sum = "+sum);
        
        //System.out.println("n1 = "+n1+" n2 = "+n2);
    }
}/*

*/
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;


@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        // Set the response content type to HTML
        response.setContentType("text/html");
        
        // Create PrintWriter to write the response
        PrintWriter pw = response.getWriter();
        
        // Retrieve input values and perform error handling
        try {
            int n1 = Integer.parseInt(request.getParameter("n1"));
            int n2 = Integer.parseInt(request.getParameter("n2"));
            String operation = request.getParameter("cal");
            
            // Include the Calculator.html page
            RequestDispatcher rd = request.getRequestDispatcher("/Calculator.html");
            rd.include(request, response);
            
            // Perform the requested operation and return the result
            switch (operation) {
                case "+":
                    pw.write("Sum = " + (n1 + n2));
                    break;
                case "-":
                    pw.write("Difference = " + (n1 - n2));
                    break;
                case "*":
                    pw.write("Product = " + (n1 * n2));
                    break;
                case "/":
                    // Handle division by zero
                    if (n2 != 0) {
                        pw.write("Division = " + ((float) n1 / n2));
                    } else {
                        pw.write("Error: Division by zero is not allowed.");
                    }
                    break;
                default:
                    pw.write("Error: Invalid operation.");
                    break;
            }
        } catch (NumberFormatException e) {
            pw.write("Error: Invalid input. Please enter valid integers.");
        } finally {
            // Close the PrintWriter
            pw.close();
        }
    }
}
