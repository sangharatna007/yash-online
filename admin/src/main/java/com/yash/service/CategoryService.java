package com.yash.service;

import java.util.List;

import com.yash.model.Category;

public interface CategoryService {

	public List getAllCategorys();

	public Category getCategory(int id);

	public Category addCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(int id);
}
