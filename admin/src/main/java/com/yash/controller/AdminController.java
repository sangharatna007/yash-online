package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.yash.model.Category;
import com.yash.model.Payment;
import com.yash.service.CategoryService;
import com.yash.service.PaymentService;

@RestController
@RequestMapping("/cate")
public class AdminController {

	@Autowired
	private CategoryService categoryService;
	
	

	// =========================================================== Get The All Categories =================================

	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> categoris = categoryService.getAllCategories();
		if (categoris == null || categoris.isEmpty()) {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Category>>(categoris, HttpStatus.OK);
	}

	// =================================================== Get By the Id =================================

	@GetMapping("/{id}")
	public ResponseEntity<Category> getById(@PathVariable int id) {
		Category cateogry = categoryService.getCategory(id);
		if (cateogry == null ) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Category>(cateogry, HttpStatus.OK);
	}

	// ======================================= Creating new Categories ===================================

	@PostMapping
	public ResponseEntity<Void> addNewCategories(@RequestBody Category category, UriComponentsBuilder ucBuilder) {

		if (categoryService.exists(category)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/cate/{id}").buildAndExpand(category.getCategoryId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ================================== Update existing Categories ======================================
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateTheExistingCategories(@PathVariable int id, @RequestBody Category category)
	{
		Category currentCategory = categoryService.getCategory(id);
		if(currentCategory == null)
		{
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
		
//		currentCategory.setCategoryId(category.getCategoryId());
		currentCategory.setCategoryTitle(category.getCategoryTitle());
		categoryService.updateCategory(currentCategory);
		
		return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
	}
	
	// =================================== Deleted Existing User ==============================
	
	//@RequestMapping("/{id}")
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExistingCategories(@PathVariable int id){
       
    	Category category = categoryService.getCategory(id);

        if (category == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        categoryService.deleteCategory(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    
 

}
