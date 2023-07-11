package com.tw.serviceImp;

import java.util.List;
import java.util.Optional;

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
		String ret = "";
		User obj = userrepo.save(user);
		if (obj != null)
			ret = "save success!";
		return ret;
	}

	@Override
	public List<User> getUsers() {
		return userrepo.findAll();
	}

	@Override
	public String userDelete(Long id) {
		userrepo.deleteById(id);
		return "deleted ";
	}

	@SuppressWarnings("deprecation")	
	@Override
	public String changeStatus(Long id) {
		User obj=userrepo.getById(id);
		obj.setStatus(0);
		userrepo.save(obj);
		return "deleted successfully!";
	}

	@Override
	public User findById(Long id) {
		Optional<User> findById = userrepo.findById(id);
		return findById.get();
	}

}
