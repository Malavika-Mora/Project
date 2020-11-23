package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.IQGSException;
import dto.Accounts;
import dto.Policy;
import dto.PolicyDetails;
import dto.PolicyQuestions;
import utils.AdminDBQueries;
import utils.AgentDBQueries;
import utils.DatabaseConnection;

public class AgentDAOImpl implements AgentDAO {
	

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	
	@Override
	public String getLineOfBusinessIdByName(String busSegName) throws IQGSException {
		// TODO Auto-generated method stub
		String businessSegmentId = null;
		boolean found = false;
		try {
			conn = DatabaseConnection.getConnection();

			PreparedStatement pst = conn.prepareStatement(AgentDBQueries.GET_LOB_NAME);
			pst.setString(1, busSegName);
			
			ResultSet rs= pst.executeQuery();
			found = rs.next();
			if(found == true) {
				businessSegmentId = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		return businessSegmentId;
	}

	@Override
	public boolean isUserExists(String userName) throws IQGSException {
		// TODO Auto-generated method stub
		boolean found = false;
		try {
			conn = DatabaseConnection.getConnection();

			PreparedStatement pst= conn.prepareStatement(AdminDBQueries.USER_EXISTS);
			pst.setString(1, userName);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				found = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
        return found;
	}

	@Override
	public int accountCreation(Accounts account) throws IQGSException {
		// TODO Auto-generated method stub
		
		int isInserted = 0;
		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AdminDBQueries.ACCOUNT_CREATION);
			pst.setString(1, account.getInsuredName());
			pst.setString(2, account.getInsuredStreet());
			pst.setString(3, account.getInsuredCity());
			pst.setString(4, account.getInsuredState());
			pst.setInt(5, account.getInsuredZip());
			pst.setString(6, account.getLineOfBusiness());
			pst.setString(7, account.getUserName());
			
			isInserted = pst.executeUpdate();
			

		} catch (SQLException e) {
			conn = DatabaseConnection.getConnection();
		} 
		
		return isInserted;

	}

	@Override
	public boolean accountValidation(String userName) throws IQGSException {
		// TODO Auto-generated method stub
		boolean found = false;
		try {
			conn = DatabaseConnection.getConnection();

			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.VALIDATE_ACCOUNT_QUERY);
			pst.setString(1, userName);
			
			ResultSet rs= pst.executeQuery();
			found = rs.next();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
        return found;

	}

	@Override
	public boolean isAccountExists(int accNumber) throws IQGSException {
		// TODO Auto-generated method stub
		boolean found = false;
		try {
			conn = DatabaseConnection.getConnection();

			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.VALIDATE_ACCOUNT);
			pst.setInt(1, accNumber);
			
			ResultSet rs= pst.executeQuery();
			found = rs.next();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
        return found;

	}

	@Override
	public String getBusSegId(int accNumber) throws IQGSException {
		String busSegId = null;
		try {
			conn = DatabaseConnection.getConnection();

			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_BUS_SEG_ID);
			pst.setInt(1, accNumber);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				busSegId = rs.getString(1);
				System.out.println("Getting business segment id :" + busSegId);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
        return busSegId;
	
	
	
	}

	@Override
	public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws IQGSException {
		// TODO Auto-generated method stub
		
		List<PolicyQuestions> policyQuestions = new ArrayList<PolicyQuestions>();
		conn = DatabaseConnection.getConnection();
		try {
		PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_POLICY_QUESTIONS);
			pst.setString(1, busSegId);
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				PolicyQuestions polQues = new PolicyQuestions();
				polQues.setPolQuesId(rs.getString(1));
				polQues.setPolQuesSeq(rs.getInt(2));
				polQues.setBusSegId(rs.getString(3));
				polQues.setPolQuesDesc(rs.getString(4));
				polQues.setPolQuesAns1(rs.getString(5));
				polQues.setPolQuesAns1Weightage(rs.getInt(6));
				polQues.setPolQuesAns2(rs.getString(7));
				polQues.setPolQuesAns2Weightage(rs.getInt(8));
				polQues.setPolQuesAns3(rs.getString(9));
				polQues.setPolQuesAns3Weightage(rs.getInt(10));
				policyQuestions.add(polQues);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return policyQuestions;
	}

	@Override
	public int getPolicyPremiumAmount(int sumOfWeightages) throws IQGSException {
		// TODO Auto-generated method stub
		int preAmt = 0;
		boolean found = false;
		try {
			conn = DatabaseConnection.getConnection();
			//System.out.println(sumOfWeightages);
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_POLICY_PREMIUM);
			pst.setDouble(1, sumOfWeightages);
			ResultSet rs= pst.executeQuery();
			//System.out.println(sumOfWeightages);
			found = rs.next();
			System.out.println(found);
			if(found == true) {
				preAmt = rs.getInt(1);
			}
			
			if(rs.next()) {
				System.out.println(sumOfWeightages);
				preAmt = rs.getInt(4);
			}
			System.out.println("Premium Amount :" + preAmt);
			
		} catch (SQLException e) {
			throw new IQGSException("problem while creating PS object"+e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}

		return preAmt;

	}

	@Override
	public int createPolicy(Policy policy) throws IQGSException {
		// TODO Auto-generated method stub
		int isInserted = 0;
		try
		{
			conn = DatabaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.CREATE_POLICY);
			pst.setDouble(1, policy.getPolicyPremium());
			pst.setInt(2, policy.getAccNumber());
			isInserted = pst.executeUpdate();
			System.out.println(policy);
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			try
			{
				pst.close();
				conn.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return isInserted;

	}

	@Override
	public int getPolicyNumber() throws IQGSException {
		// TODO Auto-generated method stub
		int polNumber = 0;
		boolean found = false;
		try
		{
			conn = DatabaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_POLICY_NUMBER);	
			ResultSet rs= pst.executeQuery();
			found = rs.next();
			System.out.println(found);
			if(found == true) {
				polNumber = rs.getInt(1);
				//System.out.println(name + " " + pwd);
			}
			System.out.println(polNumber);
					
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			try
			{
				pst.close();
				conn.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return polNumber;

	}

	@Override
	public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers)
			throws IQGSException {
	
		// TODO Auto-generated method stub
		try
		{
			conn = DatabaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.ADD_POLICY_DETAILS);	
			for(int i = 0; i < questionIds.size(); i++) {
				pst.setInt(1, polNumber);
				pst.setString(2, questionIds.get(i));
				pst.setString(3, selectedAnswers.get(i));
				pst.executeUpdate();
			}		
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			try
			{
				pst.close();
				conn.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public List<Policy> getPolicies(int accNumber) throws IQGSException {
		
		List<Policy> policies = new ArrayList<Policy>();
		Policy policy;
		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_POLICIES);
		
			pst.setInt(1,accNumber);
			ResultSet rs= pst.executeQuery();
						while(rs.next()) {
				policy = new Policy();
				policy.setPolicyNumber(rs.getInt(1));
				policy.setPolicyPremium(rs.getDouble(2));
				policy.setAccNumber(rs.getInt(3));
				policies.add(policy);
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			try
			{
				pst.close();
				conn.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return policies;
	}

	@Override
	public Accounts getAccountDetails(int accNumber) throws IQGSException {
		// TODO Auto-generated method stub
		Accounts account = new Accounts();
		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_ACCOUNT_DETAILS);	
			pst.setInt(1, accNumber);
			ResultSet rs= pst.executeQuery();

			if(rs.next()) {
				account.setAccountNumber(rs.getInt(1));
				account.setInsuredName(rs.getString(2));
				account.setInsuredStreet(rs.getString(3));
				account.setInsuredCity(rs.getString(4));
				account.setInsuredState(rs.getString(5));
				account.setInsuredZip(rs.getInt(6));
				account.setLineOfBusiness(rs.getString(7));
				
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			try
			{
				pst.close();
				conn.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		
		return account;
	}

	@Override
	public String getBusSegName(String lineOfBusiness) throws IQGSException {
		// TODO Auto-generated method stub
		String busSegName = null;
		try {
			conn = DatabaseConnection.getConnection();

			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_BUS_SEG_NAME);
			pst.setString(1, lineOfBusiness);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				busSegName = rs.getString(1);
				System.out.println("Getting business segment id :" + busSegName);
			}
		} catch (SQLException e) {
			throw new IQGSException("problem while creating PS object"+e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new IQGSException("problem while closing");
			}

		}
		
		return busSegName;

	}

	@Override
	public Double getPolicyPremium(int polNum) throws IQGSException {
		// TODO Auto-generated method stub
		Double polPremium = 0.0;
		try {
			conn = DatabaseConnection.getConnection();

			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_POLICY_PREMIUM);
			pst.setInt(1, polNum);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				polPremium = rs.getDouble(1);
				System.out.println("Getting policy premium: " + polPremium);
			}
		} catch (SQLException e) {
			throw new IQGSException("problem while creating PS object"+e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new IQGSException("problem while closing");
			}

		}
		System.out.println("policy premium in dao is : " + polPremium);
		return polPremium;

	}

	@Override
	public List<String> getSelectedAnswers(int polNum) throws IQGSException {
		// TODO Auto-generated method stub
		List<String> selectedAns = new ArrayList<String>();
		PolicyDetails details = null;
		boolean isFound = false;
		conn = DatabaseConnection.getConnection();
		try {
			
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_SELECTED_ANSWERS);
			pst.setInt(1, polNum);
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				selectedAns.add(rs.getString(1));
			}
		} catch (SQLException e) {
			throw new IQGSException("problem while creating PS object "+e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new IQGSException("problem while closing");
			}

		}
		System.out.println("Inside dao answers are:"+selectedAns);
		return selectedAns;

	}

	@Override
	public void addPolicyCreator(int polNumber, String username) throws IQGSException {
		// TODO Auto-generated method stub
		int isInserted = 0;
		try
		{
			conn = DatabaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.ADD_POLICY_CREATOR);
			pst.setInt(1, polNumber);
			pst.setString(2,username);
			isInserted = pst.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			try
			{
				pst.close();
				conn.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public int getAccountNumber(String userName) throws IQGSException {
		// TODO Auto-generated method stub
		int accNo = 0;
		try {
			conn = DatabaseConnection.getConnection();

			pst = conn.prepareStatement(AgentDBQueries.GET_ACCOUNT_NUMBER);
			pst.setString(1, userName);
			
			rs = pst.executeQuery();
			if(rs.next()) {
				
				accNo = rs.getInt(1);
				
			}
			else {
				System.out.println("No Account so please create one");
			}
		} catch (SQLException e) {
			throw new IQGSException("problem while creating PS object");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new IQGSException("problem while closing");
			}

		}
        return accNo;

	}
	
}
