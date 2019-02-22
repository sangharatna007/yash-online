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
import com.yash.model.Payment;
import com.yash.service.CategoryService;
import com.yash.service.PaymentService;

@RestController
@RequestMapping("categories")
public class AdminController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PaymentService paymentService;

	// =========================================================== Get The All Categories =================================

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> categoris = categoryService.getAllCategories();
		if (categoris == null || categoris.isEmpty()) {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Category>>(categoris, HttpStatus.OK);
	}

	// =================================================== Get By the Id =================================

	@GetMapping("/{id}")
	public ResponseEntity<Category> getById(@PathVariable("id") int id) {
		Category cateogry = categoryService.getCategory(id);
		if (cateogry == null) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Category>(HttpStatus.OK);
	}

	// ======================================= Creating new Categories ===================================

	public ResponseEntity<Void> addNewCategories(@RequestBody Category category, UriComponentsBuilder ucBuilder) {

		if (categoryService.exists(category)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		categoryService.addCategory(category);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/categories/{id}").buildAndExpand(category.getCategoryId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ================================== Update existing Categories ======================================
	
	public ResponseEntity<Category> updateTheExistingCategories(@PathVariable int id, @RequestBody Category category)
	{
		Category currentCategory = categoryService.getCategory(id);
		if(currentCategory == null)
		{
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
		
		currentCategory.setCategoryId(category.getCategoryId());
		currentCategory.setCategoryTitle(category.getCategoryTitle());
		categoryService.updateCategory(currentCategory);
		
		return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
	}
	
	// =================================== Deleted Existing User ==============================
	
	
    public ResponseEntity<Void> deleteExistingCategories(@PathVariable("id") int id){
       
    	Category category = categoryService.getCategory(id);

        if (category == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        categoryService.deleteCategory(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    
 // =========================================================== Get The All Payment Mode =================================

 	@GetMapping(produces = "application/json")
 	public ResponseEntity<List<Payment>> getAllPaymentMode() {
 		List<Payment> payment = paymentService.modeOfPayment();
 		if (payment == null || payment.isEmpty()) {
 			return new ResponseEntity<List<Payment>>(HttpStatus.NO_CONTENT);
 		}

 		return new ResponseEntity<List<Payment>>(payment, HttpStatus.OK);
 	}

 	// =================================================== Get Payment By the Id =================================

 	@GetMapping("/{id}")
 	public ResponseEntity<Payment> getPaymentById(@PathVariable("id") int id) {
 		Payment payment = paymentService.getPayment(id);
 		if (payment == null) {
 			return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);

 		}
 		return new ResponseEntity<Payment>(HttpStatus.OK);
 	}

 	// ======================================= Creating new Payment Mode ===================================

 	public ResponseEntity<Void> addNewPayments(@RequestBody Payment payment, UriComponentsBuilder ucBuilder) {

 		if (paymentService.exists(payment)) {
 			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
 		}
 		paymentService.paymentMode(payment);

 		HttpHeaders headers = new HttpHeaders();
 		headers.setLocation(ucBuilder.path("/payments/{id}").buildAndExpand(payment.getId()).toUri());
 		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
 	}
 	
 	public ResponseEntity<Void> deleteExistingPayementMode(@PathVariable("id") int id){
        
    
    	Payment payment = paymentService.getPayment(id);
    	

        if (payment == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        paymentService.removePaymentMode(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
