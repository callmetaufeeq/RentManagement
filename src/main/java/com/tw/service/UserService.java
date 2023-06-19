package com.tw.service;

import java.util.List;

import com.tw.model.User;

public interface UserService {

	String saveUser(User user);

	List<User> getUsers();

	String userDelete(Long id);

	String changeStatus(Long id);

}
