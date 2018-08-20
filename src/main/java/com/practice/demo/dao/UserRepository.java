package com.practice.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);
	
    User findByUserNameOrEmail(String username, String email);
}
