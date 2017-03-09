import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class DemoServlet3 extends HttpServlet
{
	PrintWriter out;
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		out.println("do get method called");
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
res.setContentType("text/html");
out=res.getWriter();
super.service(req,res);
out.println("<html><body>");
out.println("hello  servlet");
out.println("<br>");
out.println("Reference id="+this);
try
{
	out.println("<br>");
	Thread.sleep(2000);
	}
	catch(Exception e)
	{

	}
	out.println("<br>");
out.println("Thread Name="+Thread.currentThread().getName());

	out.println("<br>");
	out.println("</body></html>");
}
}