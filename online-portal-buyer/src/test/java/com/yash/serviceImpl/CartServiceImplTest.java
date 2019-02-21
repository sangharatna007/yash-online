package com.yash.serviceImpl;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Primary;

import com.yash.model.Product;

//@RunWith(SpringJUnit4ClassRunner.class)

public class CartServiceImplTest {

	Map<Product, Integer> productCartMap=null;
	CartServiceImpl cartServiceImpl=null;
	Product productFirst=null;
	Product productSecond=null;
	@Before
	public void setup() {
		  cartServiceImpl=new CartServiceImpl();
		  productCartMap= new HashMap<Product, Integer>();
		  productFirst=new Product(1,"Mobile", 10, 10000.00,1,1,1);
		  productSecond=new Product(2,"Mobile", 10, 10000.00,1,1,1);

	}
	@Test
	public void testCheckProductfromCart() {
		assertEquals(0, productCartMap.size());
	}

	@Test
	public void testAddSameProductToCart() {
		productCartMap=cartServiceImpl.addProductToCart(productFirst);
		productCartMap=cartServiceImpl.addProductToCart(productFirst);
		int productQuantity=productCartMap.get(productFirst);
		assertEquals(2,productQuantity );
	}
	@Test
	
	public void testRemoveProductfromCart() {
		cartServiceImpl.addProductToCart(productFirst);
		cartServiceImpl.addProductToCart(productFirst);
		productCartMap=cartServiceImpl.removeProductfromCart(productFirst);
		int productQuantity=productCartMap.get(productFirst);
		assertEquals(1, productQuantity);
	}
	
	
}
