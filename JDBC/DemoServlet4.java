import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class DemoServlet4 extends HttpServlet
{
	PrintWriter out;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/BOOKS?autoReconnect=true&useSSL=false";

   
   static final String USER = "root";
   static final String PASS = "hello123";
   
	Connection conn = null;
   Statement stmt = null;

public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{	
		res.setContentType("text/html");
		out=res.getWriter();
		out.println("<html><body>");
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		if(name.equals("test")&&pass.equals("test"))
		{
			out.println("user is valid through get");

		}
		else
		{
			out.println("user is invalid through get");
		}
	}
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
res.setContentType("text/html");
out=res.getWriter();
out.println("<html><body>");
String s=req.getMethod();
out.println("hello  servlet");
out.println("<br>");

	out.println("<br>"+s+"<br>");
out.println("Thread Name="+Thread.currentThread().getName());
if(s.equals("GET"))
	doGet(req,res);
if(s.equals("POST"))
	doPost(req,res);

	out.println("<br>");
	out.println("</body></html>");
}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	out.println("<html><body>");
String name=req.getParameter("name");
String pass=req.getParameter("pass");

try
{
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL,USER,PASS);
stmt = conn.createStatement();
ResultSet rs=stmt.executeQuery("select * from USERS");
ResultSetMetaData rsmd=rs.getMetaData();
out.println("<table bgcolor='yellow' border=1 width=200>");
out.println("<tr>");
for(int i=1;i<=6;i++)
{
	out.println("<th>"+rsmd.getColumnName(i)+"</th>");
}
out.println("</tr>");

while(rs.next())
{
	out.println("<tr>");
	out.println("<td>"+rs.getString(1)+"</td>");
	out.println("<td>"+rs.getString(2)+"</td>");
	out.println("<td>"+rs.getString(3)+"</td>");
	out.println("<td>"+rs.getInt(4)+"</td>");
	out.println("<td>"+rs.getInt(5)+"</td>");
	out.println("<td>"+rs.getString(6)+"</td>");
	out.println("</tr>");
}
}
catch(Exception e){}
out.println("</table>");
ResultSet rs=stmt.executeQuery("select * from USERS WHERE USERNAME = '"+name+"' and password ='"+pass+"'");
if(rs.next())
		{
			out.println("user is valid through POST");

		}
		else
		{
			out.println("user is invalid through POST");
		}
}
	
}
