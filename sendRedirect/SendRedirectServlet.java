import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class SendRedirectServlet extends HttpServlet
{
	PrintWriter out;
   
	Connection conn = null;
   Statement stmt = null;

public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{	
		res.setContentType("text/html");
		out=res.getWriter();
		ServletContext ctx=getServletContext();
		out.println("<html><body>");
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		try
		{
String url=ctx.getInitParameter("driver_url");
String user=ctx.getInitParameter("user");
String dbpass=ctx.getInitParameter("pass");
String driver=ctx.getInitParameter("driver");
Class.forName(driver);
conn=DriverManager.getConnection(url,user,dbpass);
stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery("select * from users where name ='"+name+"' and pass='"+pass+"'");
if(rs.next())
{

//res.sendRedirect("wel");
res.sendRedirect("http://google.com");
}
else
{
res.sendRedirect("err");
}
		}catch(Exception e)
		{

		}
	}
	}