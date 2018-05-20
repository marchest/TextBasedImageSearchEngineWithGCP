package com.xas.common.dao;

import java.util.List;
import java.util.Optional;

import com.xas.common.model.Category;

public interface CategoryDao{

	public List<Category> userCategories(String userId);

	public boolean updateCategory(Category c);
}
