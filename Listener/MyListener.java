import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class MyListener implements ServletContextListener
{
Connection c;
static final String DB_URL = "jdbc:mysql://localhost/sms?autoReconnect=true&useSSL=false";
static final String USER = "root";
static final String PASS = "hello123";

public void contextInitialized(ServletContextEvent e)
{
try
{
ServletContext ctx=e.getServletContext();
Class.forName("com.mysql.jdbc.Driver");

c=DriverManager.getConnection(DB_URL,USER,PASS);
ctx.setAttribute("con",c);
System.out.println("Context Created.");
}
catch(Exception e12){e12.printStackTrace();}
}
public void contextDestroyed(ServletContextEvent e1)
{
try{
	c.close();
}
catch(Exception e122){e122.printStackTrace();}
}
}