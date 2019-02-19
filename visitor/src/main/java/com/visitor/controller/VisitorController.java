package com.visitor.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visitor.exception.ProductNotFoundException;
import com.visitor.model.Product;
import com.visitor.service.VisitorService;
import com.visitor.serviceImpl.VisitorServiceImpl;

@RestController
public class VisitorController {
	private static final Logger LOGGER = Logger.getLogger(VisitorController.class);
	
	@Autowired
	private VisitorService visitorService;
	
	@GetMapping(value = "/products", produces = "application/json")
	ResponseEntity<?> getAllProducts(){
		LOGGER.debug("in getproducts");
		List<Product> productList = visitorService.getProductList();
		productList = null;
		if(null != productList)
			return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
		else { 
			LOGGER.error(new ProductNotFoundException("check message"));
			throw new ProductNotFoundException("Product Not found");
		}
		//throw new ArithmeticException();
		//return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
	
}
