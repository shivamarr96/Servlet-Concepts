import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.annotation.*;
@WebServlet(name="ListenerServlet",urlPatterns={"/listener"})
public class ListenerServlet extends HttpServlet
{
	PrintWriter out;
	  
	 Statement stmt = null;

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	ServletContext ctx=getServletContext();	
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	out.println("<html><body>");
try
{
Connection c=(Connection)ctx.getAttribute("con");
Statement stmt=c.createStatement();
ResultSet rs=stmt.executeQuery("select * from ORDER_HEADER");
ResultSetMetaData rsmd=rs.getMetaData();
out.println("<table bgcolor='blue' border=1 width=200>");
out.println("<tr>");
for(int i=1;i<=3;i++)
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
	out.println("</tr>");
}
}
catch(Exception e){}
out.println("</table>");
out.println("</body></html>");
}
	
}
