package com.yash.service;

import java.util.List;

import com.yash.model.Category;
import com.yash.model.Payment;

public interface CategoryService {

	public List<Category> getAllCategories();

	public Category getCategory(int id);

	public void addCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(int id);

	public boolean exists(Category category);
	
	


}
