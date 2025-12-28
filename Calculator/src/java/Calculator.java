import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Create PrintWriter to send response to the client
        PrintWriter out = response.getWriter();

        try {
            // Retrieve numbers and operation from the request
            int n1 = Integer.parseInt(request.getParameter("n1"));
            int n2 = Integer.parseInt(request.getParameter("n2"));
            String operation = request.getParameter("cal");

            int result = 0;
            String operationSymbol = "";

            // Perform the selected operation
            switch (operation) {
                case "+":
                    result = n1 + n2;
                    operationSymbol = "+";
                    break;
                case "-":
                    result = n1 - n2;
                    operationSymbol = "-";
                    break;
                case "*":
                    result = n1 * n2;
                    operationSymbol = "*";
                    break;
                case "/":
                    if (n2 != 0) {
                        operationSymbol = "/";
                        out.println("<html><body>");
                        out.println("<h3>Result:</h3>");
                        out.printf("<p>%d %s %d = %.2f</p>", n1, operationSymbol, n2, (float) n1 / n2);
                        out.println("<br><a href='index.html'>Calculate Again</a>");
                        out.println("</body></html>");
                        return;
                    } else {
                        out.println("<html><body>");
                        out.println("<h3>Error: Division by zero is not allowed.</h3>");
                        out.println("<a href='index.html'>Try Again</a>");
                        out.println("</body></html>");
                        return;
                    }
                default:
                    out.println("<html><body>");
                    out.println("<h3>Invalid operation selected.</h3>");
                    out.println("<a href='index.html'>Try Again</a>");
                    out.println("</body></html>");
                    return;
            }

            // Display the result for addition, subtraction, and multiplication
            out.println("<html><body>");
            out.println("<h3>Result:</h3>");
            out.printf("<p>%d %s %d = %d</p>", n1, operationSymbol, n2, result);
            out.println("<br><a href='index.html'>Calculate Again</a>");
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            // Handle invalid inputs
            out.println("<html><body>");
            out.println("<h3>Error: Invalid input. Please enter valid numbers.</h3>");
            out.println("<a href='index.html'>Try Again</a>");
            out.println("</body></html>");
        }
    }
}
