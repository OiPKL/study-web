package com.ssafy.mvc.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dto.User;

@Service
public class UserService {
	private final UserDao userDao;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(User user) {
		return userDao.selectUser(user);
	}

	public boolean registUser(User user) {
		try {
			int res = userDao.insertUser(user);
			return res == 1;
		} catch (Exception e) {
			return false;
		}
	}
}
