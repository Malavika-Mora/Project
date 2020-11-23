package service;

import java.sql.SQLException;

import dao.UserDaoImpl;
import dao.Userdao;
import dto.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	private Userdao dao=new UserDaoImpl();
	@Override
	public User userLogin(String UserId, String Password) throws SQLException {
		// TODO Auto-generated method stub
		User user=dao.userLogin(UserId,Password);
		return user;
	}

	}
