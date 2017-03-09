import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class MyRequestListener implements ServletRequestListener
{
public void requestInitialized(ServletRequestEvent e)
{
try{	
ServletRequest s=e.getServletRequest();
s.setAttribute("address","LONDON");
System.out.println("request Initialized");
}
catch(Exception e12){}

}
public void requestDestroyed(ServletRequestEvent e)
{

}
}