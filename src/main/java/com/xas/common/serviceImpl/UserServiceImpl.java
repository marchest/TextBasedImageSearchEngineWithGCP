package com.xas.common.serviceImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xas.common.dao.UserDao;
import com.xas.common.service.BusinessControllerService;
import com.xas.common.service.UserService;
import com.xas.common.model.User;

@Service("userService")

public class UserServiceImpl implements UserService {
	
	@Autowired(required=true)
	@Qualifier("userDAO")
	UserDao userDao;
	
	@Autowired(required=true)
	@Qualifier("businessControllerService")
	BusinessControllerService bcs;
	
	public List<User> getUsers() {
		
		return userDao.getUsers();
	}

	public boolean addUser(User user) {
		if (bcs.isAvailableUser(user.getEmail())) {
			return userDao.addUser(user);	
		}
		return false;
	}

	public User login(String email, String password){
	
		return userDao.login(email, password);
	}

	public User findByEmail(String email) {
	
		return userDao.findByEmail(email);
	}



}
