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
    
    protected  void doGet (HttpServletRequest request, HttpServletResponse response )throws IOException, ServletException { // object
    
             PrintWriter pw=response.getWriter();
             int n1=  Integer.parseInt(request.getParameter("n1"));// name value
             int n2= Integer.parseInt(request.getParameter("n2")); // getparameter value always takes string value thats why we need to type casting to change strinh to integer
             
             
             String operation=request.getParameter("cal");
             RequestDispatcher rd=request.getRequestDispatcher("/index.html");
             response.setContentType("text/html");
             rd.include(request, response);
             
             if (operation.equals("+")){
                 int sum=n1+n2;
                 pw.write("sum= "+sum);
             } else if (operation.equals("-")){
                 int sub=n1-n2;
                 pw.write("difference= "+sub);
    }
             else if (operation.equals("*")){
                 int mul=n1*n2;
                 pw.write("product=" +mul);
    }
             else if(operation.equals("/")){
                  int div=n1/n2;
                  pw.write("division ="+div);
    }
           
    }
}