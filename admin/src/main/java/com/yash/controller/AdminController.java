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
import com.yash.model.Payment;
import com.yash.service.CategoryService;
import com.yash.service.PaymentService;

@RestController
public class AdminController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PaymentService paymentService;

	@RequestMapping(value = "/categories", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Category> categoryList() {
		List<Category> listOfCategories = categoryService.getAllCategories();
		if (null == listOfCategories || listOfCategories.isEmpty()) {
			throw new NoDataException("no data");
		}
		return listOfCategories;

	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Category categoryById(@PathVariable int id) {
		Category categoryData = categoryService.getCategory(id);
		if (null == categoryData || categoryData.equals(" ")) {
			throw new NoDataByIdException("no data");
		}
		return categoryData;
	}

	@RequestMapping(value = "/categories", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addCategory(@RequestBody Category category) {
		if (category == null || category.equals(" ")) {
			throw new NoDataException("no data");
		}
		categoryService.addCategory(category);
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCategory(@RequestBody Category category, @PathVariable Integer id) {
		if (category == null || category.equals(" ")) {
			throw new NoDataException("no data");
		}
		categoryService.updateCategory(category, id);
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
	}
	
	@RequestMapping(value = "/payments", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Payment> getPayamentList() {
		List<Payment> listOfPayments = paymentService.modeOfPayment();
		if (null == listOfPayments || listOfPayments.isEmpty()) {
			throw new NoDataException("no data");
		}
		return listOfPayments;

	}
	
	@RequestMapping(value = "/payments", method = RequestMethod.POST, headers = "Accept=application/json")
	public void paymentMode( Payment payment) {
		if (payment == null || payment.equals(" ")) {
			throw new NoDataException("no data");
		}
		paymentService.paymentMode(payment);
	}
	
	@RequestMapping(value = "/payments/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void removeModeOfPayment(@PathVariable int id) {
		paymentService.removePaymentMode(id);
	}
}
