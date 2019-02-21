package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yash.dao.CategoryDao;
import com.yash.model.Category;

@Service("categoryService")
/*@Qualifier("categoryDao")*/
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

	public void updateCategory(Category category, int id) {
		categoryDao.updateCategory(category, id);
		
	}

	public void deleteCategory(int id) {
		categoryDao.deleteCategory(id);
		
	}

}
