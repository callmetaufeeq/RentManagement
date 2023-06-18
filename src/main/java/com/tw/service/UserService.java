package com.tw.service;

import java.util.List;

import com.tw.model.User;

public interface UserService {

	String saveUser(User user);

	List<User> getUsers();
	
//	String userId (User id);
//	
//	String userDelete(User id);

}
