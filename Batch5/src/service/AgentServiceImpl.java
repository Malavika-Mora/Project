package service;

import java.sql.ResultSet;
import java.util.List;

import dao.AgentDAO;
import dao.AgentDAOImpl;
import dao.AgentDAO;
import exception.IQGSException;
import dto.Accounts;
import dto.Policy;
import dto.PolicyDetails;
import dto.PolicyQuestions;

public class AgentServiceImpl implements AgentService {

	AgentDAO agentDao = new AgentDAOImpl();
	@Override
	public String getLineOfBusinessIdByName(String busSegName) throws IQGSException {
		// TODO Auto-generated method stub
		return agentDao.getLineOfBusinessIdByName(busSegName);
	}

	@Override
	public boolean isUserExists(String userName) throws IQGSException {
		// TODO Auto-generated method stub
		return agentDao.isUserExists(userName);
	}

	@Override
	public int accountCreation(Accounts account) throws IQGSException {
		// TODO Auto-generated method stub
		return agentDao.accountCreation(account);
	}

	@Override
	public boolean accountValidation(String userName) throws IQGSException {
		// TODO Auto-generated method stub
		return agentDao.accountValidation(userName);
	}

	@Override
	public boolean isAccountExists(int accNumber) throws IQGSException {
		// TODO Auto-generated method stub
		return agentDao.isAccountExists(accNumber);
	}

	@Override
	public String getBusSegId(int accNumber) throws IQGSException {
		// TODO Auto-generated method stub
		return agentDao.getBusSegId(accNumber);
	}

	@Override
	public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws IQGSException {
		// TODO Auto-generated method stub
		return agentDao.getPolicyQuestions(busSegId);
	}

	@Override
	public int getPolicyPremiumAmount(int sumOfWeightages) throws IQGSException {
		// TODO Auto-generated method stub
		return agentDao.getPolicyPremiumAmount(sumOfWeightages);
	}

	@Override
	public int createPolicy(Policy policy) throws IQGSException {
		// TODO Auto-generated method stub
		return agentDao.createPolicy(policy);
	}

	@Override
	public int getPolicyNumber() throws IQGSException {
		// TODO Auto-generated method stub
		return agentDao.getPolicyNumber();
	}

	@Override
	public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers) throws IQGSException {
		// TODO Auto-generated method stub
		agentDao.addPolicyDetails(polNumber,questionIds,selectedAnswers);
	}

	@Override
	public List<Policy> getPolicies(int accNumber) throws IQGSException {
		// TODO Auto-generated method stub
		
		return agentDao.getPolicies(accNumber);
	}

	@Override
	public Accounts getAccountDetails(int accNumber) throws IQGSException {
		
		return agentDao.getAccountDetails(accNumber);
	}

	@Override
	public String getBusSegName(String lineOfBusiness) throws IQGSException {
		// TODO Auto-generated method stub
		return agentDao.getBusSegName(lineOfBusiness);
	}

	@Override
	public Double getPolicyPremium(int polNum) throws IQGSException {
		// TODO Auto-generated method stub
		return agentDao.getPolicyPremium(polNum);
	}

	@Override
	public List<String> getSelectedAnswers(int polNum) throws IQGSException {
		// TODO Auto-generated method stub
		return agentDao.getSelectedAnswers(polNum);
	}

	@Override
	public void addPolicyCreator(int polNumber, String username) throws IQGSException {
		// TODO Auto-generated method stub
	     agentDao.addPolicyCreator(polNumber,username);
	}

	@Override
	public int getAccountNumber(String userName) throws IQGSException {
		// TODO Auto-generated method stub
		return agentDao.getAccountNumber(userName);
	}

	

}

