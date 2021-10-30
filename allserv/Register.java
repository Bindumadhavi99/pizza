package allserv;
import java.sql.*;
import  packon.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			Connection cn=GetConnection.getCn();
		int cid=(int)(Math.random()*1000);
		String cpass=request.getParameter("cpass");
		String cname=request.getParameter("cname");
		String cadr=request.getParameter("cadr");
		String cphn=request.getParameter("cphn");
		String cmail=request.getParameter("cmail");
		
		PreparedStatement ps=cn.prepareStatement("insert into customer values(?,?,?,?,?,?)");
		ps.setInt(1, cid);
		ps.setString(2, cpass);
		ps.setString(3, cname);
		ps.setString(4, cadr);
		ps.setString(5, cphn);
		ps.setString(6, cmail);
		ps.execute();
		out.print("Registration success with ID : "+cid);
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.include(request, response);
			
		}catch(Exception e) {
			
		}
	}

}



