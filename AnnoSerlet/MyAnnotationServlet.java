import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
@WebServlet(name="MyAnnotationServlet",urlPatterns={"/hello"})
public class MyAnnotationServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body>");
out.println("hello Servlet from annotation");
out.println("<br>hello");
out.println("</body></html>");
out.close();
}
}