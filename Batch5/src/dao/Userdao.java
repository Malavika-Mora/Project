package dao;

import java.sql.SQLException;

import dto.User;

public interface Userdao {
	public User userLogin(String UserId,String Password) throws SQLException ;
}
