import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
@WebServlet(name="MyAnnotationServlet",urlPatterns={"/hello"},
	initParams=
	{
		@WebInitParam(name="email",value="abc@gmail.com"),
		@WebInitParam(name="phone",value="1234567890")
	})
public class MyAnnotationServlet extends HttpServlet
{String email,phone;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		 email=config.getInitParameter("email");
		 phone=config.getInitParameter("phone");

	}
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body>");
out.println("hello Servlet from annotation");
out.println("<br>");
out.println("<h1>"+email+"</h1>");
out.println("<br>");
out.println("<h2>"+phone+"</h2>");
out.println("</body></html>");
out.close();
}
}