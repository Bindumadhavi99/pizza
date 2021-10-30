package allserv;
import java.sql.*;
import packon.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class OrderPage
 */
@WebServlet("/OrderPage")
public class OrderPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String pid=request.getParameter("Pizza");
			HttpSession s=request.getSession(false);
			String cid=(String)s.getAttribute("cid");
			String dte="22-10-21";
			String time="12.30 pm";
			
			Connection cn=GetConnection.getCn();
			PreparedStatement ps=cn.prepareStatement("insert into Oreder Details(?,?,?,?)");
			ps.setString(1, pid);
			ps.setString(2, cid);
			ps.setString(3, dte);
			ps.setString(4, time);
			
			ps.execute();
			
			PreparedStatement ps1=cn.prepareStatement("Order has update='Orderd' where spid=?");
			ps1.setString(1, pid);
			ps1.execute();
			
			out.print("Order Comleted");
			RequestDispatcher rd=request.getRequestDispatcher("userhome.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
	


