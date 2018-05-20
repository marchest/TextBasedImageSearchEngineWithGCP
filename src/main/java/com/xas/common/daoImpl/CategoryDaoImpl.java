package com.xas.common.daoImpl;

import java.util.List;
import java.util.Optional;

import javax.mail.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xas.common.dao.CategoryDao;
import com.xas.common.model.Address;
import com.xas.common.model.Category;
@Repository("category")
@Transactional
public class CategoryDaoImpl implements CategoryDao{
	
	@PersistenceContext
	public EntityManager entityManager;
	
	
	public List<Category> userCategories(String userId) {
		Query query=entityManager.createNativeQuery("select c.* from category c where c.userId=?1", Category.class);
		query.setParameter(1, userId);
		List<Category> category=query.getResultList();
		return category;
	}



	
	@Transactional
	public boolean updateCategory(Category c) {
		try {
		entityManager.merge(c);
		/*	Query query=entityManager.createNativeQuery("update category set categoryName=?,categoryState=? where userId=? and categoryId=?")
					.setParameter(1, c.getCategoryName())
					.setParameter(2, c.getCategoryState())
					.setParameter(3, c.getUserId())
					.setParameter(4, c.getCategoryId());
			query.executeUpdate();
		*/
			return true;	
		} catch (Exception e) {
			return false;
		}
		
		
	}

}
