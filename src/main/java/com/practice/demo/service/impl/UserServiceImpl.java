package com.practice.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.practice.demo.dao.UserRepository;
import com.practice.demo.domain.User;
import com.practice.demo.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userDao;

	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public User findByUserNameOrEmail(String username, String email) {
		return userDao.findByUserNameOrEmail(username, email);
	}

}
