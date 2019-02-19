package com.yash.service;

import java.beans.Transient;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.CategoryDao;
import com.yash.model.Category;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao categoryDao;

	@Transactional	
	public List getAllCategorys() {
		
		return categoryDao.getAllCategory();
	}

	@Transactional
	public Category getCategory(int id) {
		
		return categoryDao.getCategoryById(id);
	}

	@Transactional
	public Category addCategory(Category category) {
		
		return categoryDao.addCategory(category);
	}

	@Transactional
	public void updateCategory(Category category) {
		
		categoryDao.updateCategory(category);
		
	}

	@Transactional
	public void deleteCategory(int id) {
		 categoryDao.deleteCategory(id);
		
	}

}
