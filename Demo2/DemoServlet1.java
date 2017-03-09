import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class DemoServlet1 extends HttpServlet
{

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body>");
out.println("hello Servlet");
out.println("<br>");
out.println("Reference id="+this);
out.println("<br>");
String name=req.getParameter("name");
String pass=req.getParameter("pass");
if(name.equals("shivam")&&pass.equals("bhumika"))
	out.println("I'm in.");
else
	out.println("I'm out.");
	out.println("</body></html>");

}
}