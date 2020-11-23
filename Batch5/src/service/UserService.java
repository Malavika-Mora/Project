package service;

import java.sql.SQLException;

import dto.User;

public interface UserService {
	public User userLogin(String UserId,String Password) throws SQLException;

}
