package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Policy;
import exception.IQGSException;
import service.AgentService;
import service.AgentServiceImpl;

/**
 * Servlet implementation class AgentViewPolicy
 */
@WebServlet("/AgentViewPolicy")
public class AgentViewPolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String user =request.getParameter("uname");
			ServletContext context = request.getServletContext();
			context.setAttribute("uname",user);
			PrintWriter out = response.getWriter();
			RequestDispatcher dispatcher = null;
			AgentService service = new AgentServiceImpl();
			try {
			int accNo = service.getAccountNumber(user);
			List<Policy> policies = service.getPolicies(accNo);
			System.out.println("policies size : "+policies.size());
			if(policies.size() > 0) {
				request.setAttribute("policies", policies);
			
				dispatcher = request.getRequestDispatcher("AgentViewPolicy.jsp");
				dispatcher.include(request, response);
		
			}
			
			else {
				out.println("Policies does not exists.. ");
				/*dispatcher = request.getRequestDispatcher("insurerhome.html");
				dispatcher.include(request, response);*/
							
			}
		}catch (IQGSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
