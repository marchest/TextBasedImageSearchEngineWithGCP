package com.xas.common.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xas.common.dao.CategoryDao;
import com.xas.common.model.Category;
import com.xas.common.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDao categoryDao;
	
	public List<Category> userCategories(String userId) {

		return categoryDao.userCategories(userId);
	}

	public boolean updateCategory(Category c) {
		// TODO Auto-generated method stub
		return categoryDao.updateCategory(c);
	}

}
