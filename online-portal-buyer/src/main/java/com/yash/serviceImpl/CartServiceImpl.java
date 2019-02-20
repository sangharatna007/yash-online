package com.yash.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.yash.model.Product;
import com.yash.service.CartService;

@Service
public class CartServiceImpl  implements CartService{
	Map<Product, Integer> cartMap= new HashMap<Product, Integer>();
	
	public Map<Product, Integer> addProductToCart(Product product) {
		
		if (cartMap.containsKey(product)) {
			cartMap.replace(product, cartMap.get(product) + 1);
        } else {
        	cartMap.put(product, 1);
        }

		return cartMap;
	}
	

	public Map<Product, Integer> removeProductfromCart(Product product) {
		if (cartMap.containsKey(product)) {
            if (cartMap.get(product) > 1)
            	cartMap.replace(product, cartMap.get(product) - 1);
            else if (cartMap.get(product) == 1) {
            	cartMap.remove(product);
            }
        }
		return cartMap;
	}


	public Map<Product, Integer> checkProductfromCart() {
		
		return cartMap;
	}
}
