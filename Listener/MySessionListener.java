import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class MySessionListener implements HttpSessionListener
{
public void sessionCreated(HttpSessionEvent e)
{
try{	
HttpSession ses=e.getSession();
ses.setAttribute("name","ducat");
System.out.println("session created..");
}
catch(Exception e12){}

}
public void sessionDestroyed(HttpSessionEvent e)
{

}
}