package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.yash.model.Category;
import com.yash.service.CategoryService;

@RestController
@RequestMapping("categories")
public class AdminController {

	@Autowired
	private CategoryService categoryServie;

	// =========================================================== Get The All
	// Categories =================================

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> categoris = categoryServie.getAllCategories();
		if (categoris == null || categoris.isEmpty()) {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Category>>(categoris, HttpStatus.OK);
	}

	// =================================================== Get By the Id =================================

	@GetMapping("/{id}")
	public ResponseEntity<Category> getById(@PathVariable("id") int id) {
		Category cateogry = categoryServie.getCategory(id);
		if (cateogry == null) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Category>(HttpStatus.OK);
	}

	// ======================================= Creating new Categories ===================================

	public ResponseEntity<Void> addNewCategories(@RequestBody Category category, UriComponentsBuilder ucBuilder) {

		if (categoryServie.exists(category)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		categoryServie.addCategory(category);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/categories/{id}").buildAndExpand(category.getCategoryId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ================================== Update existing Categories ======================================
	
	public ResponseEntity<Category> updateTheExistingCategories(@PathVariable int id, @RequestBody Category category)
	{
		Category currentCategory = categoryServie.getCategory(id);
		if(currentCategory == null)
		{
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
		
		currentCategory.setCategoryId(category.getCategoryId());
		currentCategory.setCategoryTitle(category.getCategoryTitle());
		categoryServie.updateCategory(currentCategory);
		
		return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
	}
	
	// =================================== Deleted Existing User ==============================
	
	
    public ResponseEntity<Void> deleteExistingCategories(@PathVariable("id") int id){
       
    	Category category = categoryServie.getCategory(id);

        if (category == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        categoryServie.deleteCategory(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
