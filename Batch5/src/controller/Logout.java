package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*HttpSession session=request.getSession(false);
		if(session !=null) {
			session.removeAttribute("user");
			RequestDispatcher dispatcher=request.getRequestDispatcher("UserLogin.jsp");
			dispatcher.forward(request, response);
		}*/
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		session.setAttribute("userId",null);
		session.invalidate();
		response.sendRedirect("UserLogin.jsp");

		}
		
	}

