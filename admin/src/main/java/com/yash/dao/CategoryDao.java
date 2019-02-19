package com.yash.dao;

import java.util.List;

import com.yash.model.Category;

public interface CategoryDao {
	
	public List<Category> getAllCategory();

	Category getCategoryById(int categoryId);

	void deleteCategory(int categoryId);

	Category addCategory(Category category);

	void updateCategory(Category category);

}
