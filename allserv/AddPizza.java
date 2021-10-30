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

/**
 * Servlet implementation class AddPizza
 */
@WebServlet("/AddPizza")
public class AddPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			int pid=(int)(Math.random()*1000);
			String status="Available";
			String name=request.getParameter("Pizza");
			String cost=request.getParameter("cost");
			Connection cn=GetConnection.getCn();
			PreparedStatement ps=cn.prepareStatement("insert into Pizza values(?,?,?,?)");
			ps.setInt(1, pid);
			ps.setString(2, name);
			ps.setString(3, cost);
			ps.setString(4, status);
			ps.execute();
			
			out.print("Record saved...");
			RequestDispatcher rd=request.getRequestDispatcher("addHome.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
