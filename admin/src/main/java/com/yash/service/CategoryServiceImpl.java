package com.yash.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.dao.CatogertDao;
import com.yash.model.Category;
import com.yash.service.CategoryService;

@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {

	CatogertDao dao;

	public CatogertDao getDao() {
		return dao;
	}

	public void setDao(CatogertDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Category> getAllCategory() {

		return dao.getAllCategory();
	}

	@Override
	public Category getCategoryById(String categoryId) {

		return dao.getCategoryById(categoryId);
	}

	@Override
	public void deleteCategory(String categoryId) {
		dao.deleteCategory(categoryId);

	}

	@Override
	public void addCategory(Category category) {
		dao.addCategory(category);

	}

	@Override
	public void editCategory(Category product) {
		dao.editCategory(product);

	}

}
