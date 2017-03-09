import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class ErrorServlet extends HttpServlet
{
	PrintWriter out;
   
	
public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{	
		res.setContentType("text/html");
		out=res.getWriter();
		out.println("<html><body>");
		out.println("<h1> Invalid user FROM NEW SERVLET</h2>");	
		out.println("</body></html>");
}
}