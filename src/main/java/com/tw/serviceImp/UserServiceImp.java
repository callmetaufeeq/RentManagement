package com.tw.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.model.User;
import com.tw.repository.UserRepository;
import com.tw.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userrepo;
	
	@Override
	public String saveUser(User user) {
		String ret="";
		User obj=userrepo.save(user);
		if(obj !=null)
			ret="save success!";
		return ret;
	}

	@Override
	public List<User> getUsers() {
		return userrepo.findAll();
	}

}
