package com.yash.service;

import java.util.List;

import com.yash.model.Category;

public interface CategoryService {
	public List<Category> getAllCategory();

	Category getCategoryById(String categoryId);

	void deleteCategory(String categoryId);

	void addCategory(Category category);

	void editCategory(Category product);

}
