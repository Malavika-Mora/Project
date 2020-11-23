package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import exception.IQGSException;
import dto.Accounts;
import service.AgentService;
import service.AgentServiceImpl;


@WebServlet("/AgentAccountCreation")
public class AgentAccountCreation extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int isCreated = 0;
        boolean isAccountExists = false;
	PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		AgentService service = new AgentServiceImpl();
		boolean isUserExists = false;
		String userName = request.getParameter("userName");
		String insuredName = request.getParameter("insuredName");
		String insuredStreet = request.getParameter("insuredStreet");
		String insuredCity = request.getParameter("insuredCity");
		String insuredState = request.getParameter("insuredState");
		int insuredZip = Integer.parseInt(request.getParameter("insuredZip"));
		
		String busSegName = request.getParameter("busSegName");
		
		try {
						
			String bussinessSegmentId = service.getLineOfBusinessIdByName(busSegName);
			Accounts account = new Accounts(insuredName, insuredStreet, insuredCity, insuredState, insuredZip, bussinessSegmentId, userName);
			
			isUserExists = service.isUserExists(userName);
			if (isUserExists) {
                
				isAccountExists = service.accountValidation(userName);
				if(isAccountExists) {
					out.println("Account already exists");
					/*dispatcher = request.getRequestDispatcher("AgentPage.jsp");
					dispatcher.include(request, response);*/
				} else {
				    isCreated = service.accountCreation(account);
				    if (isCreated >0) {
					out.println("Account Created Successfully!!");
					dispatcher = request.getRequestDispatcher("AgentPage.jsp");
					dispatcher.include(request, response);
				   }
				}
			} else {
				out.println("User does not exists! First register as user");
				/*dispatcher = request.getRequestDispatcher("AgentPage.jsp");
				dispatcher.include(request, response);*/
			}
		} catch (IQGSException e) {
			System.out.println(e.getMessage());
		}

	}

}
