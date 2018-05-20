package com.xas.common.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xas.common.model.Category;

public interface CategoryService {
	public List<Category> userCategories(String userId);
	
	public boolean updateCategory(Category c);
		
	
}
