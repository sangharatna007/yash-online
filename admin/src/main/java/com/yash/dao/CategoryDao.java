package com.yash.dao;

import java.util.List;

import com.yash.model.Category;

public interface CategoryDao {

	public List<Category> getAllCategories();

	public Category getCategory(int id);

	public void addCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(int id);
	
	boolean exists(Category category);

}
