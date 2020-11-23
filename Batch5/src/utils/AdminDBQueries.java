package utils;

public class AdminDBQueries {
	
	String VALIDATE_USER_QUERY = "select * from userrole where username = ? and password = ?";
	
	String GET_ROLECODE = "select rolecode from userrole where username = ? and password = ?";
	
	String ADD_USER = "insert into userRole values(?,?,?)";
	
	public static String ACCOUNT_CREATION = "insert into accounts values(accountnumber.nextval,?,?,?,?,?,?,?)";
	
	String GET_LOB_NAME = "select bus_seg_id from business_segment where bus_seg_name = ?";
	
	public static String USER_EXISTS = "select * from userrole where username = ?";
	
	String GET_BUS_SEG_ID = "select businesssegmentid from accounts where accountnumber = ?";
	
	String GET_POLICY_QUESTIONS = "select * from policyquestions where bus_seg_id = ?";
	
	String GET_POLICY_PREMIUM_AMOUNT = "select pre_amt from premiums where ? between pre_ans_weightage_min and pre_ans_weightage_max";
	
	String CREATE_POLICY = "insert into policy values(policy_number.nextval, ?, ?)";
	
	String GET_POLICY_NUMBER = "select max(policynumber) from policy";
	
	String GET_QUESTION_IDS = "select pol_ques_id from policyquestions where bus_seg_id = ?";
	
	String ADD_POLICY_DETAILS = "insert into policydetails values(?,?,?)";
	
	String GET_POLICIES = "select * from policy";
	
	String GET_ACCOUNT_DETAILS = "select * from accounts where accountnumber = ?";
	
	String GET_BUS_SEG_NAME = "select bus_seg_name from businesssegment where bus_seg_id = ?";
	
	String GET_POLICY_PREMIUM = "select policypremium from policy where policynumber = ?";
	
	String GET_SELECTED_ANSWERS = "select answer from policydetails where policynumber = ?";
	
}
