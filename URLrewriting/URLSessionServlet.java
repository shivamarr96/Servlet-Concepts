import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class URLSessionServlet extends HttpServlet
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
String dburl=ctx.getInitParameter("driver_url");
String user=ctx.getInitParameter("user");
String dbpass=ctx.getInitParameter("pass");
String driver=ctx.getInitParameter("driver");
Class.forName(driver);
conn=DriverManager.getConnection(dburl,user,dbpass);
stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery("select * from users where name ='"+name+"' and pass='"+pass+"'");
if(rs.next())
{

HttpSession se=req.getSession();
se.setAttribute("name",name);
se.setAttribute("pass",pass);
out.println("User is valid<br> Session: "+se.isNew());
out.println("<br>");
String url=res.encodeURL("demo");
String url1=res.encodeURL("log");
out.println(url);
out.println("<br>");
out.println("<a href="+url+">demo</a>");

out.println("<br>");
out.println("<a href="+url1+">Logout</a>");

}
else
{
out.println("INVALID");
}}catch(Exception e){}
out.println("</body></html>");
	}
	}