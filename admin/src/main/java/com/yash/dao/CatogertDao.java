package com.yash.dao;

import java.util.List;

import com.yash.model.Category;

public interface CatogertDao {

	public List<Category> getAllCategory();

	Category getCategoryById(String categoryId);

	void deleteCategory(String categoryId);

	void addCategory(Category category);

	void editCategory(Category product);

}
