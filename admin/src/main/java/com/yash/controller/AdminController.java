package com.yash.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yash.model.Category;
import com.yash.service.CategoryService;

public class AdminController {
	
	@Autowired
	private CategoryService categoryService;
	
	

	@RequestMapping(value = "/admin/category/addCategory", method = RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute(value = "categoryFormObj") Category category) {
		categoryService.addCategory(category);

		return "redirect:/getAllCategory";
	}
	
	@RequestMapping("/admin/delete/{categoryId}")
	public String deleteProduct(@PathVariable(value = "categoryId") String categoryId) {


		categoryService.deleteCategory(categoryId);
		
		return "redirect:/getAllProducts";
	}

}
