package utils;

public class DBQueries {
	public static final String VALIDATEQUERY="select * from UserRole where Username= ? and Password=? ";
	public static final String ADDUSERQUERY="insert into UserRole values(?,?,?)";

}
