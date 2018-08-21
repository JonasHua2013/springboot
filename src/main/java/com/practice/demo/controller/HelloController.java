package com.practice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.dao.UserRepository;
import com.practice.demo.domain.User;

/**
 * 测试controller
 * 
 * @author JonasHua
 *
 */

@RestController
public class HelloController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/hello")
	public String hello(){
		return "hello 世界";
	}
	
	@RequestMapping("/getUser")
	@Cacheable(value="user-key")
	public User getUser() {
	    User user=userRepository.findByUserName("bb");
	    System.out.println(user.getRegTime());
	    System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
	    return user;
	}
}
