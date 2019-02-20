package com.yash.service;

import java.util.Map;

import com.yash.model.Product;

public interface CartService {

	public Map<Product,Integer> addProductToCart(Product product);
	public Map<Product,Integer>  removeProductfromCart(Product product);
	public Map<Product,Integer>  checkProductfromCart();
	
}
