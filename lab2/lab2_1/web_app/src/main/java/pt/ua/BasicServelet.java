package pt.ua;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "BasicServelet", urlPatterns = {"/home"})
public class BasicServelet extends HttpServlet {
    
    private static final long serialVersionUID = -1915463532411657451L;
 
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Basic Servelet </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Basic Servelet</h3>");

        String firstName = request.getParameter("firstname");

        if (firstName != null) {
            out.println(firstName + ", welcome to our Website!");
        } else {
            out.println("Please enter your information!");
        }
        out.println("<P>");
        out.print("<form action=\"");
        out.print("home\" ");
        out.println("method=POST>");
        out.println("Your Name:");
        out.println("<input type=text size=20 name=firstname>");
        out.println("<br>");
        out.println("<input type=submit>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse res)
    throws IOException, ServletException
    {
        doGet(request, res);
    }
}
