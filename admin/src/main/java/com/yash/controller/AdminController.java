package com.yash.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yash.model.Category;
import com.yash.service.CategoryService;

@Controller
public class AdminController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/admin/category/addCategory", method = RequestMethod.POST)
	public String addCategory(
			@Valid @ModelAttribute(value = "categoryFormObj") Category category) {
		categoryService.addCategory(category);

		return "redirect:/getAllCategory";
	}

	@RequestMapping("/admin/delete/{categoryId}")
	public String deleteProduct(
			@PathVariable(value = "categoryId") String categoryId) {

		categoryService.deleteCategory(categoryId);

		return "redirect:/getAllProducts";
	}

	@RequestMapping(value = "/admin/category/editCategory/{categoryId}")
	public ModelAndView getEditCategory(
			@PathVariable(value = "categoryId") String categoryId) {
		Category category = categoryService.getCategoryById(categoryId);
		return new ModelAndView("editProduct", "editProductObj", category);
	}
	
	@RequestMapping("/getCategoryList")
	public @ResponseBody List<Category> getCategoryListInJson() {
		return categoryService.getAllCategory();
	}

}
