import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class SessionListenerServlet extends HttpServlet
{
	PrintWriter out;
	  

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		out=res.getWriter();
		out.println("<html><body>");
		HttpSession s=req.getSession();
		String name=(String)s.getAttribute("name");

		out.println("name:"+name);

		out.println("session:"+s.isNew());
		out.println("</body></html>");
}
}