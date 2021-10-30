package allserv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String aid=request.getParameter("aid");
			String apas=request.getParameter("apas");
			if(aid.equals("admin") && apas.equals("pass")) {
				RequestDispatcher rd=request.getRequestDispatcher("adminhome.html");
				rd.forward(request, response);
			}else {
				out.print("wrong userid or password");
				RequestDispatcher rd=request.getRequestDispatcher("adminlogin.html");
				rd.include(request, response);
				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
