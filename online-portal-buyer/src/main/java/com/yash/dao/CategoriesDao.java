package com.yash.dao;


import java.util.List;

import com.yash.model.Category;
import com.yash.model.Product;

public interface CategoriesDao {
	public List<Category> getAllCategory();
	public List<Product> getProductUnderCategory(int categoryId);
}
