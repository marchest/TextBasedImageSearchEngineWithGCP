package com.xas.common.daoImpl;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xas.common.AppUtils.AppUtil;
import com.xas.common.dao.UserDao;
import com.xas.common.model.User;


@Repository("userDAO")
@Transactional
public class UserDaoImpl implements UserDao {

	
	public static final String SQL_GET_ALL="select u from User u";
	@PersistenceContext
	public EntityManager entityManager;

	
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return entityManager.createQuery(SQL_GET_ALL).getResultList();
	}
	
	
	public boolean addUser(User user) {
		 UUID uuid = UUID.randomUUID();
	        String randomUUIDString = uuid.toString();
		
	        Query query =entityManager.createNativeQuery("Insert into userprofile(userGuid,userName,userSurName,email,password,InsertDate) values(?,?,?,?,?,?)");
	        query.setParameter(1,randomUUIDString);
	        query.setParameter(2,user.getUserName());
	        query.setParameter(3,user.getSurName());
	        query.setParameter(4,user.getEmail());
	        query.setParameter(5,user.getPassword());
	        query.setParameter(6,Calendar.getInstance().getTime());
	        
	        query.executeUpdate();
	        
		return true;
	}


	@SuppressWarnings("unchecked")
	public User login(String email, String password){
		Query query =entityManager.createNativeQuery("Select u.* from userprofile u where u.email= ? and u.password= ?",User.class);
		
		query.setParameter(1, email);
		query.setParameter(2,password);
		User ux=null;
		List<User> u= query.getResultList();
		for (User user : u) {
			 ux=user;
		}
		
		
//		for (Object[] objects : ux) {
//			System.out.println(objects[0].toString());
//		}
		//	User u=  AppUtil.rowmapper(query.getResultList(),User.class);
		
		
		return ux;
	}


	public User findByEmail(String email) {
	Query query =entityManager.createNativeQuery("Select u.* from userprofile u where u.email= ? ",User.class);
		
		query.setParameter(1, email);
		
		User ux=null;
		List<User> u= query.getResultList();
		for (User user : u) {
			 ux=user;
		}
		return ux;
	}


}
