package com.yash.service;

import java.util.List;

import com.yash.model.Category;
import com.yash.model.Product;

public interface CategoriesService {
	public List<Category> getAllCategory();
	public List<Product> getProductUnderCategory(int categoryId);
}
