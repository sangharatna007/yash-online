package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yash.exception.NoDataByIdException;
import com.yash.exception.NoDataException;
import com.yash.model.Category;
import com.yash.service.CategoryService;

@RestController
public class AdminController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/categories", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Category> getCategoryList() {
		List<Category> listOfCategories = categoryService.getAllCategories();
		if (null == listOfCategories || listOfCategories.isEmpty()) {
			throw new NoDataException("no data");
		}
		return listOfCategories;

	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Category getCategoryById(@PathVariable int id) {
		Category categoryData = categoryService.getCategory(id);
		if (null == categoryData || categoryData.equals(" ")) {
			throw new NoDataByIdException("no data");
		}
		return categoryData;
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addCountry(@RequestBody Category category) {
		if (category == null || category.equals(" ")) {
			throw new NoDataException("no data");
		}
		categoryService.addCategory(category);
	}

	@RequestMapping(value = "/updateCategory/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCountry(@RequestBody Category category, @PathVariable Integer id) {
		if (category == null || category.equals(" ")) {
			throw new NoDataException("no data");
		}
		categoryService.updateCategory(category, id);
	}

	@RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
	}
}
