import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
@WebServlet(name="MyAnnotationServlet",urlPatterns={"/fileupload"})
@MultipartConfig(location="C:\\Users\\Shivam Arora\\Desktop\\java\\Servlets\\Uploadedfiles",
	fileSizeThreshold=1024*1024,
	maxFileSize=1024*1024*5,
	maxRequestSize=1024*1024*5*5)
public class MyAnnotationServlet extends HttpServlet
{

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
String name=req.getParameter("filename");
Part p=req.getPart("content");
p.write(name+".jpg");
if(req.getPart("content")!=null)
{
out.println("<h1>FILE UPLOADED SUCCESSFULLY</h1>");	
}
out.close();
}
}