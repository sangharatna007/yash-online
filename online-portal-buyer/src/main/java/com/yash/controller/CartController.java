package com.yash.controller;

import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Product;
import com.yash.service.CartService;
import com.yash.utils.Constants;

@RestController
@RequestMapping("/cart")
public class CartController {
	private static final Logger log = Logger.getLogger(CartController.class);
	
	@Autowired
	private CartService cartService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/products")
	public ResponseEntity addProductToCart( @RequestBody Product product) {
		
		log.info("****inside addProductToCart handler***** " + product);
		
		if(null!=product) {
			Map<Product, Integer> cartData=cartService.addProductToCart(product);
			log.info("****inside addProductToCart handler cartData***** " + cartData);
			if (null != cartData && cartData.size()!=0) 
				return	new ResponseEntity<Object>(cartData, HttpStatus.OK);
			return new ResponseEntity(Constants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping(value = "/products")
	public ResponseEntity removeProductToCart(@Valid @RequestBody Product product) {
		
		log.info("****inside removeProductToCart handler***** " + product);
		
		if(null!=product) {
			Map<Product, Integer> cartData=cartService.removeProductfromCart(product);
			log.info("****inside removeProductToCart handler  cartData***** " + cartData);
			if (null != cartData && cartData.size()!=0) 
					return	new ResponseEntity<Object>(cartData, HttpStatus.OK);
			return new ResponseEntity(Constants.CART_IS_EMPTY, HttpStatus.OK);
		}
		return null;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/products")
	public ResponseEntity checkProductToCart() {
		log.info("****inside checkProductToCart handler***** " );
			Map<Product, Integer> cartData=cartService.checkProductfromCart();
			log.info("****inside checkProductToCart handler cartData ***** "+cartData );
			if (null != cartData && cartData.size()!=0) 
					return	new ResponseEntity<Object>(cartData, HttpStatus.OK);
			return new ResponseEntity(Constants.CART_IS_EMPTY, HttpStatus.OK);
	}
}
