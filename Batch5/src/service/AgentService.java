package service;

import java.sql.ResultSet;
import java.util.List;

import exception.IQGSException;
import dto.Accounts;
import dto.Policy;
import dto.PolicyDetails;
import dto.PolicyQuestions;

public interface AgentService {

	public String getLineOfBusinessIdByName(String busSegName) throws IQGSException;

	public boolean isUserExists(String userName) throws IQGSException;

	public int accountCreation(Accounts account) throws IQGSException;

	public boolean accountValidation(String userName) throws IQGSException;

	public boolean isAccountExists(int accNumber) throws IQGSException;

	public String getBusSegId(int accNumber) throws IQGSException;

	public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws IQGSException;

	public int getPolicyPremiumAmount(int sumOfWeightages) throws IQGSException;

	public int createPolicy(Policy policy) throws IQGSException;

	public int getPolicyNumber() throws IQGSException;
	

	public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers) throws IQGSException;

    public Accounts getAccountDetails(int accNumber) throws IQGSException;

	public String getBusSegName(String lineOfBusiness) throws IQGSException;

	public Double getPolicyPremium(int polNum) throws IQGSException;
	
	public List<String> getSelectedAnswers(int polNum) throws IQGSException;

	public void addPolicyCreator(int polNumber, String username) throws IQGSException;
	
	public List<Policy> getPolicies(int accNumber) throws IQGSException;
	public int getAccountNumber(String userName) throws IQGSException;

}
