package allserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import packon.GetConnection;

/**
 * Servlet implementation class UserLogin1
 */
@WebServlet("/UserLogin1")
public class UserLogin1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				PrintWriter out=response.getWriter();
				String aid=request.getParameter("aid");
				String apas=request.getParameter("apas");
				Connection cn=GetConnection.getCn();
				PreparedStatement ps=cn.prepareStatement("select cid,cname from customer where cid=? and cpass=?");
				ps.setString(1, aid);
				ps.setString(2, apas);
				
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					HttpSession s1=request.getSession();
					s1.setAttribute("cid", rs.getString(1));
					HttpSession s2=request.getSession();
					s2.setAttribute("cname", rs.getString(2));
					RequestDispatcher rd=request.getRequestDispatcher("userhome.html");
					rd.forward(request, response);
					
				}else {
					out.print("wrong id/password");
					RequestDispatcher rd=request.getRequestDispatcher("login.html");
					rd.include(request, response);
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}

	

	}


