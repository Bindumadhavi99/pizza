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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				PrintWriter out=response.getWriter();
				HttpSession s=request.getSession();
				String pid=(String)s.getAttribute("pid");
				String Name=request.getParameter("Name");
				String cost=request.getParameter("cost");
				Connection cn=GetConnection.getCn();
				PreparedStatement ps=cn.prepareStatement("update Pizza set Name=?,cost=? where pid=?");
				ps.setString(1, Name);
				ps.setString(2, cost);
				ps.setString(3, pid);
				ps.execute();
				out.print("Record updated...");
				RequestDispatcher rd=request.getRequestDispatcher("adminhome.html");
				rd.include(request, response);
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
}

	




