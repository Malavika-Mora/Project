package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Userdao;
import dto.User;
import utils.DBQueries;
import utils.DatabaseConnection;

public class UserDaoImpl implements Userdao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	@Override
	public User userLogin(String UserId, String Password)throws SQLException {
		conn=DatabaseConnection.getConnection();
			PreparedStatement pst=conn.prepareStatement(DBQueries.VALIDATEQUERY);
			pst.setString(1, UserId);
			pst.setString(2,Password);
			ResultSet res=pst.executeQuery();
			 User user=null;
			 if(res.next()) {
				 user=new User();
				 user.setRoleCode(res.getString("roleCode"));
			 }
			 conn.close();
		
		
		return user;
	

}
}
