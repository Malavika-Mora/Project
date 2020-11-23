package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Policy;
import exception.IQGSException;
import service.AgentService;
import service.AgentServiceImpl;

/**
 * Servlet implementation class AdminPremiumGeneration
 */
@WebServlet("/AgentPremiumGeneration")
public class AgentPremiumGeneration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		AgentService service = new AgentServiceImpl();

		ServletContext context = request.getServletContext();
		int polPremium = 0;
		int sumOfWeightages = 0;
		int isInserted = 0;
		int accNumber = 0;
		int polNumber = 0;
		int numOfQuestions = Integer.parseInt(request.getParameter("numofquestions"));
		List<String> questionIds = new ArrayList<String>();
		List<String> selectedAnswers = new ArrayList<String>();
		RequestDispatcher dispatcher = null;
		List<Integer> weightages = new ArrayList<Integer>();
		String str="question";
		//String[] qandA=new String[3];
		//List<Integer> weight=new ArrayList();
		for(int i=1;i<=numOfQuestions;i++) {
			if(request.getParameter(str+i)!=null) {
				String[] qandA=new String[3];
				qandA=request.getParameter(str+(i)).split("!");
				questionIds.add(qandA[0]);
				selectedAnswers.add(qandA[1]);
			weightages.add(Integer.parseInt(qandA[2]));
			 sumOfWeightages+=Integer.parseInt(qandA[2]);
			}
		}
		out.print(sumOfWeightages);
		Policy policy = new Policy();
		try {
			//context.setAttribute("accNumber", accNumber);
			accNumber = Integer.parseInt(""+context.getAttribute("accNumber"));
			//polPremium = service.getPolicyPremiumAmount(sumOfWeightages);
			//System.out.println(accNumber);
			policy.setAccNumber(accNumber);
			policy.setPolicyPremium(sumOfWeightages);
			isInserted = service.createPolicy(policy);
			if(isInserted > 0) {
				//out.println("Policy created successfully!!!!");
				polNumber = service.getPolicyNumber();
				service.addPolicyDetails(polNumber, questionIds, selectedAnswers);
				System.out.println("In Premium generation servlet "+polNumber);
				dispatcher = request.getRequestDispatcher("AgentPage.jsp");
				dispatcher.include(request, response);
				
			}		
		} catch (IQGSException e) {
			e.printStackTrace();
		}
	}
	}