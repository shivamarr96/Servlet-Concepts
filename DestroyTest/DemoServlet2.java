import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class DemoServlet2 extends GenericServlet
{
	PrintWriter out;
	static int count=0;
	public void destroy(){
		out.println("destroy");
count++;
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
res.setContentType("text/html");
out=res.getWriter();
destroy();
out.println("<html><body>");
out.println("hello  generic servlet"+count);
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
public ServletConfig getServletConfig()
{
	return null;
}
public String getServletInfo()
{
return null;
}
}