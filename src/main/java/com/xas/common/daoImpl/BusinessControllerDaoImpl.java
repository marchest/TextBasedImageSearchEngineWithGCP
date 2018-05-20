package com.xas.common.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xas.common.dao.BusinessControllerDao;
import com.xas.common.model.User;

@Repository("businessControllerDao")
@Transactional
public class BusinessControllerDaoImpl implements BusinessControllerDao {
	@PersistenceContext
	public EntityManager entityManager;

	public boolean isAvailableUser(String email) {
		
		Query query=entityManager.createNativeQuery("Select u.userId from userprofile u where email = ?");
		
		query.setParameter(1, email);
		
		Integer i = null;
		try {
			i= (Integer) query.getSingleResult();
		} catch (NoResultException  e) {
			// TODO: handle exception
		}
		
		
		if (i!=null) {
			return false;
		}	
		return true;
	}

	}


