package com.xas.common.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xas.common.model.User;



public interface UserService {
	
	public List<User> getUsers();
	
	public boolean addUser(User user);
	
	public User login(String email, String password);
	
	public abstract User findByEmail(String email);
}
