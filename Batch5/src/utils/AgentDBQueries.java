package utils;

public class AgentDBQueries {


	 String AGENT_VERIFY_USER="SELECT ROLECODE FROM USERROLE WHERE USERNAME=?";
	 
	 String USER_EXISTS_IN_ACCOUNT = "select username from accounts where username = ?";
	 
	 public static String ACCOUNT_CREATION = "insert into accounts values(?,?,?,?,?,?,?,?)";
	 
	 public static String VALIDATE_ACCOUNT_QUERY ="select * from accounts where username = ?";
	 
	 public static String GET_LOB_NAME = "select bus_seg_id from business_segment where bus_seg_name = ?";
		
	 String AGENT_VERIFY_ACCOUNT="SELECT BUSINESSSEGMENTID FROM ACCOUNTS WHERE ACCOUNTNUMBER=?";
	 
	 String INSERT_POLICY="INSERT INTO POLICY VALUES(policyNumberSeq.nextval,?,?)";
	 
	 String INSERT_POLICYDETAILS="INSERT INTO POLICYDETAILS VALUES((SELECT MAX(POLICYNUMBER) FROM POLICY),?,?)";
	 
	 String INSERT_POLICYCREATOR="INSERT INTO POLICYCREATOR VALUES((SELECT MAX(POLICYNUMBER) FROM POLICY),?)";

	public static String VALIDATE_ACCOUNT = "select * from accounts where accountnumber = ?";

	public static String GET_BUS_SEG_ID = "select businesssegment from accounts where accountnumber = ?";

	public static String GET_POLICY_QUESTIONS = "select * from policy_questions where bus_seg_id = ?";

	public static String GET_POLICY_PREMIUM_AMOUNT = "select pre_amt from premiums where ? between pre_ans_weightage_min and pre_ans_weightage_max";

	public static String CREATE_POLICY = "insert into policy values(policynumber.nextval, ?, ?)";
	 
	public static String GET_POLICY_NUMBER = "select max(policynumber) from policy";
	
	public static String ADD_POLICY_DETAILS = "insert into policydetails values(?,?,?)";

	public static String GET_POLICIES = "select * from policy where accountnumber= ?";

	public static String GET_ACCOUNT_DETAILS = "select * from accounts where accountnumber = ?";
	
    public static String GET_BUS_SEG_NAME = "select bus_seg_name from business_segment where bus_seg_id = ?";
	
	public static String GET_POLICY_PREMIUM = "select policypremium from policy where policynumber = ?";
	
	 public static String GET_SELECTED_ANSWERS = "select answer from policydetails where policynumber = ?";
	
	public static String ADD_POLICY_CREATOR = "insert into policycreator values(?,?)";
	public static String GET_ACCOUNT_NUMBER="select accountnumber from accounts where username=?";
	

}
