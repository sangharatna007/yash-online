package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yash.dao.CategoryDao;
import com.yash.model.Category;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	public List<Category> getAllCategories() {

		return categoryDao.getAllCategories();
	}

	public Category getCategory(int id) {

		return categoryDao.getCategory(id);
	}

	public void addCategory(Category category) {
		categoryDao.addCategory(category);
		
	}

	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
		
	}

	public void deleteCategory(int id) {
		categoryDao.deleteCategory(id);
		
	}

	public boolean exists(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

}
