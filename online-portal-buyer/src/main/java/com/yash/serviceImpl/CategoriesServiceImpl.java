package com.yash.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.CategoriesDao;
import com.yash.exception.CategoryNotFoundException;
import com.yash.model.Category;
import com.yash.model.Product;
import com.yash.service.CategoriesService;
import com.yash.utils.Constants;

@Service

public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoriesDao categoriesDao;
	
	public List<Category> getAllCategory() {
		List<Category> categoryList=categoriesDao.getAllCategory();
		if(null==categoryList)
			throw new CategoryNotFoundException(Constants.CATEGORY_NOT_FOUND);
		return categoryList;
	}

	public List<Product> getProductUnderCategory(int categoryId) {
		List<Product> productList=categoriesDao.getProductUnderCategory(categoryId);
		if(null==productList)
			throw new CategoryNotFoundException(Constants.CATEGORY_NOT_FOUND);
		return productList;
	}

}
