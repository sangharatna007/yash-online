package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Category;
import com.yash.service.CategoryService;

@RestController
public class AdminController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/getAllCategorys", method = RequestMethod.GET, headers = "Accept=application/json")
	public List getProductList() {
		System.out.println("inside controller");
		List listOfProducts = categoryService.getAllCategorys();
		return listOfProducts;

	}

	@RequestMapping(value = "/getCategory/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Category getProductById(@PathVariable int id) {
		return categoryService.getCategory(id);
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addCountry(@RequestBody Category category) {
		categoryService.addCategory(category);

	}

	@RequestMapping(value = "/updateCategory", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCategory(@RequestBody Category category) {
		categoryService.updateCategory(category);
	}

	@RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCategory(@PathVariable("id") int id) {
		categoryService.deleteCategory(id);
	}

}
