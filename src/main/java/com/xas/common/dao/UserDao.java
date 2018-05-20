package com.xas.common.dao;


import java.util.List;




import com.xas.common.model.User;

public interface UserDao {
//	public User getUser(String email);
	
	public List<User> getUsers();
	
	public boolean addUser(User user);
		
	public User login(String email, String password);
	
	public abstract User findByEmail(String email);
	

}
