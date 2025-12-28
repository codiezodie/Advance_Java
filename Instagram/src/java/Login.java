import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        String myname = request.getParameter("name1");
        String mypassword = request.getParameter("pass1");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginhere", "root", "");
            
            PreparedStatement ps = con.prepareStatement("insert into login values(?,?)");
            ps.setString(1, myname);
            ps.setString(2, mypassword);
            
           int count=ps.executeUpdate();
               if(count>0)
               {
                 response.setContentType("text/html");
                 out.print("<h3 style='color:black'>User registered successfully.</h3>");
                 RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
                 rd.include(request,response);
               }else{
                  response.setContentType("text/html");
                  out.print("<h3 style='color:red'>User not registered due to some error.</h3>");
                  RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
                  rd.include(request,response);
                   
               }
               
           } catch(Exception e){
                e.printStackTrace();
               
                response.setContentType("text/html");
                out.print("<h3 style='color:red'>Exception Occured:"+e.getMessage()+"</h3>");
                RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
                rd.include(request,response);
           }
            
        }
        }
    