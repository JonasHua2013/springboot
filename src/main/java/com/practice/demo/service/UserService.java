package com.practice.demo.service;

import com.practice.demo.domain.User;

public interface UserService {
	
	User findByUserName(String userName);
	
    User findByUserNameOrEmail(String username, String email);
}
