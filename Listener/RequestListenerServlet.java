import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class RequestListenerServlet extends HttpServlet
{
	PrintWriter out;
	  
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		out=res.getWriter();
		out.println("<html><body>");
		System.out.println("after Servlet request Initialized..");
		String name=(String)req.getAttribute("address");

		out.println("address:"+name);
		out.println("</body></html>");
}
}