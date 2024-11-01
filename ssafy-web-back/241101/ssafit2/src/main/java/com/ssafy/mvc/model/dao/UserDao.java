package com.ssafy.mvc.model.dao;

import com.ssafy.mvc.model.dto.User;

public interface UserDao {
	public User selectUser(User user);

	public int insertUser(User user);
}
