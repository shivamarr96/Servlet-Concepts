import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class MyCookie extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
	
	res.setContentType("text/html");
	PrintWriter out;
	out=res.getWriter();
	out.println("<html><body>");
	Cookie c[]=req.getCookies();
	if(c==null)
	{
		Cookie c1=new Cookie("name","shivam");
		Cookie c2=new Cookie("address","london");
		res.addCookie(c1);
		res.addCookie(c2);
		c1.setMaxAge(30*60);
		c2.setMaxAge(30*60);
		out.println("cookies added..");
	}	
	else
	{
for(int i=0;i<c.length;i++)
	{
out.println(c[i].getName()+":"+c[i].getValue());
out.println("<br>");
}
	}

		out.println("</body></html>");
}
}