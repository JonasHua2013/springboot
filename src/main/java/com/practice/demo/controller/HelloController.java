package com.practice.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller
 * 
 * @author JonasHua
 *
 */

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(){
		return "hello world";
	}
}
