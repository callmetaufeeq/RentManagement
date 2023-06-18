package com.tw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.model.User;
import com.tw.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userservice;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody User user) {
		String ret=userservice.saveUser(user);
		return ret;
	}
	
	@GetMapping("/listUser")
	public List<User> getUsers() {
		return userservice.getUsers();
	}
	
	
}
