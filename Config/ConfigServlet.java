import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class ConfigServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
	ServletConfig con;
	con=getServletConfig();
	String img=con.getInitParameter("Image");
	String driver=con.getInitParameter("Driver");
	res.setContentType("text/html");
	PrintWriter out;
	out=res.getWriter();
	out.println("<html><body background="+img+">");
	out.println("Driver Name through getInitParameter:"+driver);
	out.println("</body></html>");
}
}